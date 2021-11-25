import {EventEmitter, Injectable} from '@angular/core';
import Swal, { SweetAlertIcon } from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class SwalService {

  clickConfirm: EventEmitter<void>;
  clickCancel: EventEmitter<void>;

  constructor() {
  }

  error(tittle: string, text: string): void {
    Swal.fire({
        title: tittle,
        text: text,
        icon: 'error',
        position: 'center',
        confirmButtonColor: '#ff00ff80'
    });
}

  alert(title): void {
    Swal.fire(title as SweetAlertIcon);
  }

  succes(title: string): void {
    Swal.fire({
      position: 'top-end',
      icon: 'success',
      title: title,
      showConfirmButton: false,
      timer: 1500
    })
  }

  danger(title: string): void {
    Swal.fire({
      position: 'top-end',
      icon: 'error',
      title: title,
      showConfirmButton: false,
      timer: 1500
    })
  }

  iniciarObservablesConfirm(): void {
    this.clickConfirm = new EventEmitter();
    this.clickCancel = new EventEmitter();
  }

  confirm(
    title = '',
    text = '',
    icon = 'warning',
    confirmButtonText = 'si',
    cancelButtonText = 'no',
    {
      clickConfirm = () => {
      }, clickCancel = () => {
    }
    } = {},
    showCancelButton = true
  ): Promise<any> {
    this.iniciarObservablesConfirm();
    return Swal.fire({
      title,
      text,
      icon: icon as SweetAlertIcon,
      showCancelButton,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText,
      cancelButtonText
    }).then(result => {
      if (result.value) {
        this.clickConfirm.subscribe(() => clickConfirm());
        this.clickConfirm.emit();
        this.clickConfirm.unsubscribe();
      } else {
        this.clickCancel.subscribe(() => clickCancel());
        this.clickCancel.emit();
        this.clickCancel.unsubscribe();
      }
    });
  }
}