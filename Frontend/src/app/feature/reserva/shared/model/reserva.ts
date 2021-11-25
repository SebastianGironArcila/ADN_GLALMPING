export class Reserva{


    id:number;
    cedula: string;
    nombre:string;
    fechaEntrada: String;
    idGlamping: number;
    cantPersonas: number;
    telefono: string;
    fechaSalida: String;
    costoTotal: number;
    fechaRegistro: String;


    
    constructor( id:number,
        cedula: string,
        nombre:string,
        fechaEntrada: String,
        idGlamping: number,
        cantPersonas: number,
        telefono: string,
        fechaSalida: String,
        costoTotal: number,
        fechaRegistro: String){

        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaEntrada = fechaEntrada;
        this.idGlamping = idGlamping;
        this.cantPersonas = cantPersonas;
        this.telefono = telefono;
        this.fechaSalida = fechaSalida;
        this.costoTotal = costoTotal;
        this.fechaRegistro = fechaRegistro;

    }

}