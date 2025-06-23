$(document).ready(function () {
    const modal = new bootstrap.Modal($('#modalDepartamento'));
    const tabla = $('#tablaDepartamentos').DataTable({
        ajax: {
            url: '/api/departamentos',
            dataSrc: ''
        },
        columns: [
            { data: 'idDepartamento' },
            { data: 'nombre' },
            { data: 'ubicacion' },
            {
                data: null,
                render: function (data) {
                    return `
                        <button class="btn btn-sm btn-outline-primary btnEditar" data-id="${data.idDepartamento}">
                            <i class="fas fa-edit"></i>
                        </button>
                        <button class="btn btn-sm btn-outline-danger btnEliminar" data-id="${data.idDepartamento}">
                            <i class="fas fa-trash"></i>
                        </button>`;
                }
            }
        ]
    });

    $('#btnNuevo').click(function () {
        $('#modalTitle').text('Nuevo Departamento');
        $('#idDepartamento').val('');
        $('#nombre').val('');
        $('#ubicacion').val('');
        modal.show();
    });

    $('#tablaDepartamentos tbody').on('click', '.btnEditar', function () {
        const id = $(this).data('id');
        $.get(`/api/departamentos/${id}`, function (data) {
            $('#modalTitle').text('Editar Departamento');
            $('#idDepartamento').val(data.idDepartamento);
            $('#nombre').val(data.nombre);
            $('#ubicacion').val(data.ubicacion);
            modal.show();
        });
    });

    $('#tablaDepartamentos tbody').on('click', '.btnEliminar', function () {
        const id = $(this).data('id');
        if (confirm('¿Seguro que deseas eliminar este departamento?')) {
            $.ajax({
                url: `/api/departamentos/${id}`,
                type: 'DELETE',
                success: function () {
                    tabla.ajax.reload();
                }
            });
        }
    });

    $('#formDepartamento').submit(function (e) {
        e.preventDefault();
        const id = $('#idDepartamento').val();
        const datos = {
            nombre: $('#nombre').val(),
            ubicacion: $('#ubicacion').val()
        };
        const url = id ? `/api/departamentos/${id}` : '/api/departamentos';
        const metodo = id ? 'PUT' : 'POST';

        $.ajax({
            url: url,
            type: metodo,
            contentType: 'application/json',
            data: JSON.stringify(datos),
            success: function () {
                modal.hide();
                tabla.ajax.reload();
            }
        });
    });
});