<?php

interface Crudable {
    function create($objNegoci);
    function read($objNegoci);
    function update($objNegoci);
    function delete($objNegoci);
}

?>

