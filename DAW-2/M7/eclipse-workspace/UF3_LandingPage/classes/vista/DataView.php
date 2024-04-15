<?php

class DataView extends View {

    public static function show($lang, $langTraduccions, $dates, $frmErrors, $data = null) {
        $fitxer = "languages/{$lang}_traduccions.php";
        include_once $fitxer;
        
        $view = new View();
        $navIdiomes = $view->mostrarMenuIdiomes($lang, $langTraduccions);

        $formE = '<form id="form-entrada" action="" method="post">
                    <h2>Data</h2>
                    <div class="fe-inputs">
                        <label for="dData">Data</label>
                        <input type="text" id="dData" name="dData" placeholder="Escriu una data..." value="' . ($data ? $data->getData() : "") . '">
                        <div class="errors"><span class="error">' . $frmErrors["data1"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["data2"] . '</span></div>
                        <label for="hora">Hora</label>
                        <input type="text" id="hora" name="hora" placeholder="Escriu una hora..." value="' . ($data ? $data->getHora() : "") . '">
                        <div class="errors"><span class="error">' . $frmErrors["hora1"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["hora2"] . '</span></div>
                        <div class="fe-sInputs">
                            <input type="submit" id="cancelar" name="cancelar" value="Cancelar">
                            <input type="submit" id="enviar" name="enviar" value="Enviar">
                        </div>
                    </div>
                </form>';

        $thead = '<table id="tEntrada"><thead><tr>';
        $th = array(
            "ID",
            "Data",
            "Hora",
            ""
        );
        foreach ($th as $titol) {
            $thead .= "<th> $titol </th>";
        }
        $thead .= "</tr></thead>";

        $tbody = "<tbody>";
        foreach ($dates as $d) {
            $tbody .= '<tr>
                        <td>' . $d->getId() . '</td>
                        <td>' . $d->getData() . '</td>
                        <td>' . $d->getHora() . '</td>
                        <td class="mInputs">
                            <a href="?Data/show/'.$d->getId().'"><img src="img/editar.png" alt="editar.img"/></a>
                            <a href="?Data/delete/'.$d->getId().'"><img src="img/eliminar.png" alt="eliminar.img"/></a>
                        </td>
                       </tr>';
        }
        $tbody .= "<tbody></table>";
        $taulaE = $thead . $tbody;

        include "templates/head.tpl.php";
        include "templates/header-entrada.tpl.php";
        include "templates/main-entrada.tpl.php";
        include "templates/footer.tpl.php";
    }
}

