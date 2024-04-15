<?php
error_reporting(E_ALL);
ini_set("display_errors", 1);
session_set_cookie_params(0);
session_start();

include 'classes/config/Autoloader.php';
spl_autoload_register("Autoloader::load");
spl_autoload_register("Autoloader::newLoad");

try {
//     $cFront = new frontcontroller();
//     $cFront->dispatch();
    

/*
 
    //$dates = DataModel::read();
    $data = new Data();
//     $data->id = 200;
//     $data->data = "2023-01-01";
//     $data->hora = "18:00";
//     DataModel::create($data);

    $data->id = 137;
    $data->data = "2023-01-15";
    $data->hora = "21:00";
//     DataModel::update($data);
    DataModel::delete($data);
    
    $dates = DataModel::read();
    
    echo "<pre>";
    var_dump($dates);
    echo "<pre>";
*/

/*
    $mEntrada = new EntradaModel();
    
//     $entrada = new Entrada();
//     $entrada->__set("id","1111DDDD444S");
//     $entrada->butaca=1;
//     $entrada->fila=1;
//     $entrada->dni="44003603A";
    
//     $mEntrada->create($entrada);
    
//     $entrada->fila=12;
//     $entrada->butaca=12;
//     $mEntrada->update($entrada);
    
    $mEntrada->delete($entrada);
    
    $ent = $mEntrada->read();
    
    
    echo "<pre>";
    var_dump($ent);
    echo "<pre>";
*/
    
    
/*
    $mEsdeveniment = new EsdevenimentModel();
    $esd = $mEsdeveniment->read();
    echo "<pre>";
    var_dump($esd);
    echo "<pre>";
*/
    
/*    
    $mZona = new ZonaModel(); 
    //$mZona->create(new Zona(28,"Cuenca"));
    //$mZona->delete(new Zona(27));
    //$mZona->update(new Zona(27,"Zamora"));
    $zones = $mZona->read();
    
    echo "<pre>";
    var_dump($zones);
    echo "<pre>";
*/
    
    
    
} catch (Exception $e) {
    $vError = new ErrorView();
    $vError->show($e);
}
