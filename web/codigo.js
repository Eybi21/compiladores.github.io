function enviarFormulario() {
  var formulario = document.forms["formulario"];
  var archivo = formulario.elements["archivo"].files[0];
  var formData = new FormData();
  formData.append("archivo", archivo);
  var xhr = new XMLHttpRequest();
  xhr.open("POST", "ProcesoArchivo", true);
  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {
      document.getElementById("respuesta").innerHTML = xhr.responseText;
    }
  };
  xhr.send(formData);
}