CLASSE MODELO PARA QUE TODOS SUS METODOS SEAN DE CLASE, es decir, ponerlos todos en static

class Model {
    private static $db;

    public static function setDB($db) {
        self::$db = $db;
    }

    public static function find($table, $id) {
        // Implementación de búsqueda en la base de datos
    }

    public static function findAll($table) {
        // Implementación de búsqueda en la base de datos
    }

    public static function insert($table, $data) {
        // Implementación de inserción en la base de datos
    }

    public static function update($table, $id, $data) {
        // Implementación de actualización en la base de datos
    }

    public static function delete($table, $id) {
        // Implementación de eliminación en la base de datos
    }
}

// Uso:
Model::setDB($miConexion);
Model::insert('usuarios', ['nombre' => 'Juan', 'edad' => 30]);
?>