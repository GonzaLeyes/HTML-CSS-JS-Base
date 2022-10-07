let nombre ="";
let titulo ="";
let localidad ="";

function editarPerfil(){
    //Traer una foto para subir
}

//Nombre
function editarAcercaDe(){
    document.getElementById("edit-nombre").style.display="block"
    document.getElementById("edit-titulo").style.display="block"
    document.getElementById("edit-localidad").style.display="block"
};

function registrarNombre(valor){
    nombre = valor;
    console.log(nombre);
}

function registrarTitulo(valor){
    titulo = valor;
    console.log(titulo);
}

function registrarLocalidad(valor){
    localidad = valor;
    console.log(localidad);
}

let text_nombre = document.getElementById("edit-nombre");
text_nombre.addEventListener("keyup",function(event){
    if(event.code === 'Enter'){
        enviarCambio("nombre-completo", nombre);
        document.getElementById("edit-nombre").style.display="none";
    }
});

let text_titulo = document.getElementById("edit-titulo");
text_titulo.addEventListener("keyup",function(event){
    if(event.code === 'Enter'){
        enviarCambio("titulo", titulo);
        document.getElementById("edit-titulo").style.display="none";
    }
});

let text_localidad = document.getElementById("edit-localidad");
text_localidad.addEventListener("keyup",function(event){
    if(event.code === 'Enter'){
        enviarCambio("localidad", localidad);
        document.getElementById("edit-localidad").style.display="none";
    }
});

function enviarCambio(caja, dato){
    document.getElementById(caja).innerText = dato;
}

/* Sector Experiencia*/
function agregarExp(){

}

function editarExp(){

}

function eliminarExp(){

}
/* Sector Educación*/
function agregarEdu(){

}

function editarEdu(){

}

function eliminarEdu(){

}

/* Sector Skills*/
function agregarSkill(){

}

function editarSkill(){

}

function eliminarSkill(){

}
