$(function () {
    let dialog, form,
        nota = $("#nota"),
        tipus = $("#tipus"),
        dataInici = $("#dataInici"),
        dataFinal = $("#dataFinal"),
        allFields = $([]).add(nota).add(tipus).add(dataInici).add(dataFinal),
        tips = $(".validateTips");

    function updateTips(t) {
        tips
            .text(t)
            .addClass("ui-state-highlight");
        setTimeout(function () {
            tips.removeClass("ui-state-highlight", 1500);
        }, 500);
    }

    function checkIfEmpty(o, n) {
        if (o.val() === '') {
            o.addClass("ui-state-error");
            updateTips("El camp " + n + " no pot estar buit.");
            return false;
        } else {
            return true;
        }
    }

    function formatDate(date) {
        let day = ("0" + date.getDate()).slice(-2);
        let month = ("0" + (date.getMonth() + 1)).slice(-2);
        let year = date.getFullYear();
        return day + '/' + month + '/' + year;
    }

    function addTask() {
        let valid = true;
        allFields.removeClass("ui-state-error");
    
        valid = valid && checkIfEmpty(nota, "nota");
        valid = valid && checkIfEmpty(tipus, "tipus");
        valid = valid && checkIfEmpty(dataInici, "data d'inici");
        valid = valid && checkIfEmpty(dataFinal, "data final");
    
        if (valid) {
            let table = $("#notes-b tbody");
            let row = $("<tr>");
            row.append($("<td>").text(nota.val()));
            row.append($("<td>").text(tipus.val()));
            let dataIniciDate = new Date(dataInici.val());
            let dataFinalDate = new Date(dataFinal.val());
            row.append($("<td>").text(formatDate(dataIniciDate)));
            row.append($("<td>").text(formatDate(dataFinalDate)));
            table.append(row);

            dialog.dialog("close");
        }
        
        saveData();
        return valid;
    }

    dialog = $("#dialog-form").dialog({
        autoOpen: false,
        height: 475,
        width: 350,
        modal: true,
        buttons: {
            "Crear una tasca": addTask,
            Cancelar: function () {
                dialog.dialog("close");
            }
        },
        close: function () {
            form[0].reset();
            allFields.removeClass("ui-state-error");
        }
    });

    form = dialog.find("form").on("submit", function (event) {
        event.preventDefault();
        addTask();
    });

    $("#afegir-tasca").button().on("click", function () {
        dialog.dialog("open");
    });

    $("#restaurar").button().on("click", function () {
        localStorage.removeItem('dades');
        localStorage.removeItem('dades_kanban');
        location.reload();
    });

    $("#notes-b tbody, #notes-s tbody, #trash tbody").sortable({
        connectWith: "#notes-b tbody, #notes-s tbody, #trash tbody",
        update: function(event, ui) {
            $(this).find('.placeholder').toggle($(this).children('tr').length <= 1);
            if ($(this).is("#notes-b tbody, #notes-s tbody")) {
                ui.item.find('td').removeClass('eliminar');
            }
            saveData();
        }
    }).disableSelection();

    $("#notes-b tbody, #notes-s tbody, #trash tbody").each(function() {
        $(this).find('.placeholder').toggle($(this).children('tr').length <= 1);
    });

    $("#trash tbody").sortable({
        connectWith: "#notes-b tbody, #notes-s tbody, #trash tbody",
        receive: function(event, ui) {
            ui.item.find('td').addClass('eliminar');
            saveData();
        }
    }).disableSelection();

    $("#t-borrar").on("click", function () {
        $("#trash tbody tr:not(.placeholder)").fadeOut(500, function () {
            $(this).remove();
            $("#trash tbody").find('.placeholder').toggle($("#trash tbody").children('tr').length <= 1);
            saveData();
        });
    });

    function saveData() {
        let dades = {
            backlog: $("#notes-b tbody").html(),
            sprint: $("#sprint tbody").html(),
            trash: $("#trash tbody").html()
        };
        localStorage.setItem('dades', JSON.stringify(dades));
    }

    function loadData() {
        let dadesObtingudes = JSON.parse(localStorage.getItem('dades'));
        if (dadesObtingudes) {
            if (dadesObtingudes.backlog) {
                $("#notes-b tbody").html(dadesObtingudes.backlog);
            }
            if (dadesObtingudes.sprint) {
                $("#sprint tbody").html(dadesObtingudes.sprint);
            }
            if (dadesObtingudes.trash) {
                $("#trash tbody").html(dadesObtingudes.trash);
            }
        }

        $("#notes-b tbody, #notes-s tbody, #sprint tbody, #trash tbody").each(function() {
            $(this).find('.placeholder').toggle($(this).children('tr').length <= 1);
        });
    }

    $(loadData);
});