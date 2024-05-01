<?php

class EntradaView extends View {
    public function __construct() {
        parent::__construct();
    }

    public function show($lang, $langTraduccions, $entrades, $frmErrors, $esdeveniments, $dates, $localitzacions, $zones, $pagaments, $entrada = null) {
        $fitxer = "languages/{$lang}_traduccions.php";
        include_once $fitxer;
        
        $navIdiomes = $this->mostrarMenuIdiomes($lang, $langTraduccions);
        
        $formE = '<form id="form-entrada" action="" method="post">
            <h2>Entrada</h2>
            <div class="fe-inputs">
                <label for="eEsdeveniments">Esdeveniments</label>
                <select id="eEsdeveniments" name="eEsdeveniments">';
        foreach ($esdeveniments as $es) {
            $selected = ($entrada != null && $entrada->esdeveniment->id == $es->id) ? 'selected' : '';
            $formE .= "<option value='$es->id' $selected>$es->titol</option>";
        }
        
        $formE .= '</select>
           <label for="eDates">Dates i Hores</label>
           <select id="eDates" name="eDates">';
        foreach ($dates as $da) {
            if ($entrada != null && $entrada->data != null) {
                $id = method_exists($entrada->data, 'getId') ? $entrada->data->getId() : $entrada->data->id;
                $selected = ($id == $da->getId()) ? 'selected' : '';
            }
           
            $formE .= "<option value='" . $da->getId() . "' $selected>" . $da->getData() . " (" . $da->getHora() . ")</option>";
        }
        
        $formE .= '</select>
           <label for="eLocalitzacions">Localitzacions i Localitats</label>
           <select id="eLocalitzacions" name="eLocalitzacions">';
        foreach ($localitzacions as $lo) {
            $selected = ($entrada != null && $entrada->loc->id == $lo->id) ? 'selected' : '';
            $formE .= "<option value='$lo->id' $selected>$lo->lloc ($lo->localitat)</option>";
        }
        
        $formE .= '</select>
           <label for="eZones">Zones</label>
           <select id="eZones" name="eZones">';
        foreach ($zones as $zo) {
            $selected = ($entrada != null && $entrada->zona->id == $zo->id) ? 'selected' : '';
            $formE .= "<option value='$zo->id' $selected>$zo->descripcio</option>";
        }
        
        $formE .= '</select>
           <label for="ePagaments">Pagaments</label>
           <select id="ePagaments" name="ePagaments">';
        foreach ($pagaments as $pa) {
            $selected = ($entrada != null && $entrada->pagament->id == $pa->id) ? 'selected' : '';
            $formE .= "<option value='$pa->id' $selected>$pa->banc</option>";
        }
        
        $formE .= '</select>
                    <div id="eCamps">
                        <div id="eF">
                        <label for="fila">Fila</label>
                        <input type="text" id="fila" name="fila" placeholder="Escriu una fila..." value="' . ($entrada ? $entrada->fila : "") . '">
                        <div class="errors"><span class="error">' . $frmErrors["fila1"] . '</span></div>
                        <div class="errors"><span class="error">' . $frmErrors["fila2"] . '</span></div>
                        </div>
                        <div id="eB">
                             <label for="butaca">Butaca</label>
                             <input type="text" id="butaca" name="butaca" placeholder="Escriu una butaca..." value="' . ($entrada ? $entrada->butaca : "") . '">
                             <div class="errors"><span class="error">' . $frmErrors["butaca1"] . '</span></div>
                             <div class="errors"><span class="error">' . $frmErrors["butaca2"] . '</span></div>
                        </div>
                        <div id="eD">
                            <label for="eDni">DNI</label>
                            <input type="text" id="eDni" name="eDni" placeholder="Escriu un DNI..." value="' . ($entrada ? $entrada->dni : "") . '">
                            <div class="errors"><span class="error">' . $frmErrors["dni1"] . '</span></div>
                            <div class="errors"><span class="error">' . $frmErrors["dni2"] . '</span></div>
                        </div>
                    </div>
                    <div class="fe-sInputs">
                        <input type="submit" id="cancelar" name="cancelar" value="Cancelar">
                        <input type="submit" id="enviar" name="enviar" value="Enviar">
                    </div>
                </div>
            </form>';

        $thead = '<table id="tEntrada"><thead><tr>';
        $th = array(
            "ID",
            "Fila",
            "Butaca",
            "DNI",
            "Esdeveniment",
            "Data i Hora",
            "Lloc i Localitat",
            "Zona",
            "Pagament",
            ""
        );
        foreach ($th as $titol) {
            $thead .= "<th> $titol </th>";
        }
        $thead .= "</tr></thead>";

        $tbody = "<tbody>";
        foreach ($entrades as $e) {
            $tbody .= '<tr>
                        <td>' . $e->id . '</td>
                        <td>' . $e->fila . '</td>
                        <td>' . $e->butaca . '</td>
                        <td>' . $e->dni . '</td>
                        <td>' . $e->esdeveniment->titol. '</td>
                        <td>' . $e->data->getData() . " " . $e->data->getHora() . '</td>
                        <td>' . $e->loc->lloc . " (" . $e->loc->localitat . ")" . '</td>
                        <td>' . $e->zona->descripcio . '</td>
                        <td>' . $e->pagament->banc . '</td>
                        <td class="mInputs">
                            <a href="?Entrada/show/'.$e->id.'"><img src="img/editar.png" alt="editar.img"/></a>
                            <a href="?Entrada/delete/'.$e->id.'"><img src="img/eliminar.png" alt="eliminar.img"/></a>
                        </td>
                    </tr>';
        }
        $tbody .= "</tbody></table>";
        $taulaE = $thead . $tbody;

        include "templates/head.tpl.php";
        include "templates/header-entrada.tpl.php";
        include "templates/main-entrada.tpl.php";
        include "templates/footer.tpl.php";
    }
}

