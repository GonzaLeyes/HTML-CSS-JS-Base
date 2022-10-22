export class persona{
    //con el ? le indicamos que la variable no es necesaria
    id?: number;
    nombre: String;
    apellido: String;
    img: String;


    constructor(nombre: String, apellido: String, img: String){
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
    }
}