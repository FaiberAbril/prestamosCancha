
function calcularTotalPagar() {
    let Cantidad = document.getElementById('Cantidad').value;
    alert
    let precio = document.getElementById('precio').value;
    let valorPagar = Cantidad * precio;
    document.getElementById('ValorPagar').value = valorPagar;
}

document.getElementById('Cantidad').addEventListener('change', calcularTotalPagar);
document.getElementById('precioProducto').addEventListener('change', calcularTotalPagar);





