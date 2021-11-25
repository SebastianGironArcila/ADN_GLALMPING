export class Glamping{
    id:number;
    idTipoGlamping:number;
    descripcion: string;
    precio: number;
    estado: number;


    constructor(id:number,idTipoGlamping: number,descripcion: string,precio:number,estado:number){

        this.id=id;
        this.idTipoGlamping = idTipoGlamping;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
        

    }
}