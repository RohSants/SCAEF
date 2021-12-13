/* Funções em desenvolvimento */

/*var opcao = document.getElementById("funcaoselecionada").value;
var crf = document.querySelector('.crf');

function hideCrf(farm){
    if(opcao === "Farmaceutico"){
        crf.style.display = 'none';
    } else {
        crf.style.display = 'inline-block';
    }
}*/

var x = document.getElementById("tooltiptext");

        function mostraTexto(){
            x.style.cssText = 
                'visibility: visible;' +
                'opacity: 1;' 
        }

        function escondeTexto(){
            x.style.cssText = 
            'opacity = 0;' + 
            'visibility = "hidden";'

          
        }

/* Funções dos formulários de cadastro */

function mascaraCpf(mascara, input){
    const vetMasc = mascara.split("")
    const numCpf =  input.value.replace(/\D/g, "")
    const cursor =  Number(input.selectionStart)
    const tecla = (window.event) ? event.keyCode : event.which

    for(let i = 0; i <numCpf.length; i++){
        vetMasc.splice(vetMasc.indexOf("_"), 1, numCpf[i])
    }

    input.value = vetMasc.join("")

    if(tecla != 37 && (cursor == 3 || cursor == 7 || cursor == 11)){
        input.setSelectionRange(cursor+1, cursor+1)
    }else{
        input.setSelectionRange(cursor, cursor)
    }
}

function mascaraRg(mascara, input){
    const vetMasc = mascara.split("")
    const numRg =  input.value.replace(/\D/g, "")
    const cursor =  Number(input.selectionStart)
    const tecla = (window.event) ? event.keyCode : event.which

    for(let i = 0; i <numRg.length; i++){
        vetMasc.splice(vetMasc.indexOf("_"), 1, numRg[i])
    }

    input.value = vetMasc.join("")

    if(tecla != 37 && (cursor == 2 || cursor == 5 || cursor == 8)){
        input.setSelectionRange(cursor+1, cursor+1)
    }else{
        input.setSelectionRange(cursor, cursor)
    }
}

function mascaraFone(mascara, input){
    const vetMasc = mascara.split("")
    const numF =  input.value.replace(/\D/g, "")
    const cursor =  Number(input.selectionStart)
    const tecla = (window.event) ? event.keyCode : event.which

    for(let i = 0; i <numF.length; i++){
        vetMasc.splice(vetMasc.indexOf("_"), 1, numF[i])
    }

    input.value = vetMasc.join("")

    if(tecla != 37 && (cursor == 1 || cursor == 4 || cursor == 8)){
        input.setSelectionRange(cursor+1, cursor+1)
    }else{
        input.setSelectionRange(cursor, cursor)
    }
}

function mascaraCel(mascara, input){
    const vetMasc = mascara.split("")
    const numC =  input.value.replace(/\D/g, "")
    const cursor =  Number(input.selectionStart)
    const tecla = (window.event) ? event.keyCode : event.which

    for(let i = 0; i <numC.length; i++){
        vetMasc.splice(vetMasc.indexOf("_"), 1, numC[i])
    }

    input.value = vetMasc.join("")

    if(tecla != 37 && (cursor == 1 || cursor == 3 || cursor == 8)){
        input.setSelectionRange(cursor+1, cursor+1)
    }else{
        input.setSelectionRange(cursor, cursor)
    }
}
