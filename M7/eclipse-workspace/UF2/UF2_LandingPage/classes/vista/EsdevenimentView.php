<?php

class EsdevenimentView extends View {
    public function __construct() {
        parent::__construct();
    }

    public function show($idioma, $esdeveniments, $frmErrors, $esdeveniment = null) {
        $fitxer = "languages/{$idioma}_traduccions.php";
        require_once $fitxer;

        $formE = '<form id="form-entrada" action="" method="post" enctype="multipart/form-data">
                    <h2>Esdeveniment</h2>
                    <div class="fe-inputs">
                        <label for="titol">Títol</label>
                        <input type="text" id="titol" name="titol" placeholder="Escriu un títol..." value="' . ($esdeveniment ? $esdeveniment->titol : "") . '">
                        <div class="errors"><span class="error">' . $frmErrors["titol1"] . '</span></div>
                        <label for="subtitol">Subtítol</label>
                        <input type="text" id="subtitol" name="subtitol" placeholder="Escriu un subtítol..." value="' . ($esdeveniment ? $esdeveniment->subtitol : "") . '">
                        <label for="dates">Dates</label>
                        <input type="text" id="dates" name="dates" placeholder="Escriu les dates..." value="' . ($esdeveniment ? $esdeveniment->dates : "") . '">
                        <div class="errors"><span class="error">' . $frmErrors["dates1"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["dates2"] . '</span></div>
                        <label for="imatge">Imatge</label>
                        <input type="file" id="imatge" name="imatge">
                        <div class="errors"><span class="error">' . $frmErrors["imatge1"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["imatge2"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["imatge3"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["imatge4"] . '</span></div>
                        <div class="fe-sInputs">
                            <input type="submit" id="cancelar" name="cancelar" value="Cancelar">
                            <input type="submit" id="enviar" name="enviar" value="Enviar">
                        </div>
                    </div>
                </form>';

        $thead = '<table id="tEntrada"><thead><tr>';
        $th = array(
            "ID",
            "Titol",
            "Subtitol",
            "Dates",
            "Imatge",
            ""
        );
        foreach ($th as $titol) {
            $thead .= "<th> $titol </th>";
        }
        $thead .= "</tr></thead>";

        $tbody = "<tbody>";
        foreach ($esdeveniments as $e) {
            $tbody .= '<tr>
                        <td>' . $e->id . '</td>
                        <td>' . $e->titol . '</td>
                        <td>' . $e->subtitol . '</td>
                        <td>' . $e->dates . '</td>
                        <td><img src="' . $e->imatge . '" alt="' . $e->imatge . '"></td>
                        <td class="mInputs">
                            <a href="?Esdeveniment/show/'.$e->id.'"><img src="img/editar.png" alt="editar.img"/></a>
                            <a href="?Esdeveniment/delete/'.$e->id.'"><img src="img/eliminar.png" alt="eliminar.img"/></a>
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

