# Apuntes UF3 - M7

## Pasos para instalar Doctrine
- Crear un proyecto en PHP
- Desde consola, dirigirnos a la carpeta del proyecto
- Iniciar el composer con:
```
	composer init
```
- Seguiremos los pasos que nos indica. Las respuestas para un proyecto serían:
	- Enter
	- Descripcion
	- Autor
	- Enter
	- project
	- Enter
	- y
	- doctrine
	- 0
	- 2.8
	- n
	- src/
	- y
	- y
- A partir de aqui crearemos una carpeta config en el proyecto con 2 archivos:
	- config.php
		```
		<?php
		// Configuració de l'aplicació
		// Accés a la base de dades
		$dbParams = [
			'driver' =>'pdo_mysql' ,
			'host' =>'127.0.0.1' ,
			'dbname' =>'doctrine_MonroyHector',
			'user' =>'usr_generic' ,
			'password' =>'2024@Thos'
		];
		// Estem en mode desenvolupament?
		$dev = true;
		```
	- cli-config.php
		```
		<?php
		// Configuració del CLI de Doctrine.
		// Dependencia de l'objecte ConsoleRunner
		use Doctrine\ORM\Tools\Console\ConsoleRunner;
		// Incluem el bootstrap per obtenir l' "Entity Manager"
		require_once __DIR__.'/../src/bootstrap.php';
		// Retornem l'objecte HelperSet de consola
		return ConsoleRunner::createHelperSet($entityManager);
		```
- Dentro de la carpeta <strong>src</strong> crearemos un archivo bootstrap.php
	```
	<?php
	use Doctrine\ORM\Tools\Setup;
	use Doctrine\ORM\EntityManager;
	require_once __DIR__ . '/../vendor/autoload.php';
	require_once __DIR__ . '/../config/config.php';
	$entitiesPath = array(
		__DIR__ . '/cinema/Entity'
	);
	$config = Setup::createAnnotationMetadataConfiguration($entitiesPath, $dev);
	$entityManager = EntityManager::create($dbParams, $config);
	```

##### Cuidado
En el <strong>$entitiesPath</strong>, cambiar a donde apunta las entidades.

Después de hacer esto, si nos situamos en la carpeta raíz del proyecto y ejecutamos el siguiente comando, ya tendremos instalado doctrine.
```
php vendor/doctrine/orm/bin/doctrine.php
```

#### Atención
Para agregar los <strong>namespace</strong>, debemos añadirlos en el compose.json. La primera parte indica el namespace, la segunda parte a que carpeta apunta. Esto se hace añadiéndolos de esta manera:
```
"psr-4" : {
	"Frases\\Entity\\" : "src/Frases/Entity",
	"Frases\\Repository\\" : "src/Frases/Repository"
}
```

## Generación de entidades

Para generar las entidades con las que doctrine trabajará contra nuestra base de datos, tendremos que hacer unos pasos previos antes. (También aplica para Repositories)

- Crearemos una carpeta con un nombre (Frases, por ejemplo) en el que se situarán nuestras entidades. También sirve para los repositories
- Dentro de esa carpeta, crearemos la carpeta Entity en la que situaremos nuestros archivos PHP que definirán las entidades de doctrine.
- Crearemos una clase y definiremos nuestra entidad como si fuese un objeto de negocio. 

Una diferencia entre un objeto de negocio común de PHP y una entidad de Doctrine son las anotaciones. Doctrine trabaja con anotaciones que definen como se crearán las entidades.

Para añadir una anotación, se hara mediante ```/** ```. Se usan para documentación del código al qual precede, ya sean clases, propiedades, funciones, etc.

Para mapear propiedades de una columna de una tabla en una base de datos relacional se usa la anotación ```@Column``` y especificar el tipo de mapaje que hay entre ellas. Si no se especifica, se define como un <strong>String</strong> por defecto.

La anotacion ```@Column``` tiene algunos otros atributos como:
- <strong>type</strong>: opcional, por defecto string, establece el tipo de mapeo a usar para la columna.
- <strong>name</strong>: opcional, por defecto el nombre de la propiedad, establece el nombre de la columna en la base de datos.
- <strong>length</strong>: opcional, por defecto 255, la longitud de la columna en la base de datos, (solo por string).
- <strong>unique</strong>: opcional, por defecto FALSE, establece si la columna es una clave única.
- <strong>nullable</strong>: opcional, por defecto FALSE, establece si la columna puede ser nula.
- <strong>precision</strong>: opcional, por defecto 0, establece la precisión para una columna decimal, solo si es un campo decimal.
- <strong>scale</strong>: opcional, por defecto 0, establece la escala para una columna decimal, solo si es un campo decimal.

Las entidades necesitan una clave primaria. Con ```@id``` Se pueden definir. OJO! @id no significa que sea una id, significa clave primaria.

Podemos hacer que esta clave primaria sea <strong>autoincremental</strong> con ```@GeneratedValue```.

Ejemplos de anotaciones:
- Clave primaria autoincremental de tipo Integer:
```
/**
	* 
	* @var int
	* 
	* @Id
	* @GeneratedValue
	* @Column(type="integer")
*/
private $id;
```
- Propiedad de tipo string de longiud 500
```
/**
	* @var string
	* 
	* @Column(type="string", length=500)
*/
private $texto;
```

## Relaciones

### Direcciones.
En doctrine, para relacionar entidades, hay que tener en cuenta la direccion. Es decir, si son <strong>unidireccionales</strong> o <strong>bidireccionales</strong>.

- <strong>Unidireccionales</strong>: Estas entidades solo se pueden ser obtenidas desde las entidades principales, solo tienen un lado, el <strong>owner</strong>. Esto quiere decir que solo podré acceder a ellas desde otra entidad, nunca de esta hacia otra.

- <strong>Bidireccionales</strong>: Este tipo de entidades pueden ser obtenidas desde la entidad principal y, a su vez, las entidades principales pueden ser obtenidas desde las relacionadas. Se dice que tienen un lado <strong>owner</strong> y otro lado <strong>inverse</strong>.

Doctrine solo gestiona la parte propietaria (<strong>owner</strong>) de una asociación, por lo que deberemos de indicar siempre el lado de esta.

En una bidireccional, el <strong>owner</strong> tendrá el atributo ```inversedBy``` y la parte inversa (<strong>inverse</strong>) tendrá ```mappedBy```.

Por defecto, ```@OneToOne``` y ```@ManyToOne``` son persistidas en SQL mediante una clave primaria (id) y una clave foránea. Las asociaciones ```@ManyToMany``` tienen una tabla intermedia.

Los nombres se generan automáticamente por Doctrine, pero podemos cambiarles el nombre con las anotaciones ```@JoinColumn``` y ```@JoinTable```.

<strong>Ejemplos</strong>:

#### Relación Film - Comment
- En Comment agregaremos <strong>$pelicula</strong>. Esto agregará un nuevo campo con un identificador de la película que corresponde al comentario.

	```
	/**
		* @var Film
		* @ManyToOne(targetEntity="Film", inversedBy="comentaris")
	*/
	private $pelicula ;
	```

- En Film definiremos <strong>$comentaris</strong>, que será un Array de <strong>Comments</strong>. Como es un array, también lo inicializaremos en el constructor y crearemos un método para añadir comentarios.
	
	```
	/**
		* @var Coment[]
		* @OneToMany(targetEntity="Coment", mappedBy="pelicula")
	*/
	private $comentaris;
	```

	```
	/**
		* Inicialitzem coleccions
	*/
	public function __construct(){
		$this-> comentaris = new ArrayCollection ();
	}

	/**
		* Add Coment
		* @param Coment $comentari
		* @return Film
	*/
	public function addComentari( Coment $comentari){
		$this-> comentaris [] = $comentari;
		$comentaris->setPelicula($this);
		return $this;
	}
	```
#### Relación Film - Tag

- En Film definiremos <strong>$etiquetes</strong> y modificaremos el constructor (se le añade lo mismo que $comentaris, pero para $etiquetes).
	```
	/**
		* @var Tag[]
		*
		* @ManyToMany(targetEntity="Tag", inversedBy="pelicules",
		* 	fetch="EAGER", cascade={"persist"}, orphanRemoval=true
		* )
		* @JoinTable(
		* 	name="movie_tag",
		* 	inverseJoinColumns={
		* 		@JoinColumn(name="tag_name", referencedColumnName="name") 
		*	}
		* )
	*/
	private $etiquetes;
	```

	```
	/**
		* Inicialitzem coleccions
	*/
	public function __construct(){
		$this->comentaris = new ArrayCollection ();
		$this->etiquetes = new ArrayCollection ();
	}
	```

- En tag definiremos <strong>$pelicules</strong>. Agregaremos el método de añadir peliculas y el _toString()
	```
	/**
		* @var Film[]
		* @ManyToMany(targetEntity="Film", mappedBy="etiquetes" )
	*/
	private $pelicules;
	```

	```
	/**
		* Add pelicules
		* @param Film $pelicula
		* @return Tag
	*/
	public function addPelicula(Film $pelicula){
		$this->pelicules[] = $pelicula;
		$pelicula->addEtiqueta($this);
		return $this;
	}

	// Cast de l'objete com string
	public function __toString() {
		return $this->getTexto();
	}
	```

### Cardinalidad.
Podemos definir las entidades con un tipo de cardinalidad. Es decir, cuantas entidades pueden tener asociadas entre ellas.

- <strong>1:1 @OneToOne</strong>: Cada entidad principal solo puede tener una asociada.
- <strong>1:N @OneToMany</strong>: Cada entidad principal puede tener varias asociada.
- <strong>N:1 @ManyToOne</strong>: Varias entidades pueden tener una asociada. Solo disponibles para asociaciones bidireccionales como inversa 1:N.
- <strong>N:N @ManyToMany</strong>: Varias entidades pueden tener un conjunto de entidades asociadas.

### Hidratación.
En doctrine, la hidratación es el nombre que recibe el proceso de obtener un resultado final de una consulta en BD y mapearlo a un ResultSet.

Pueden haber varios tipos de resultados que devuelva este proceso:

- Entidades
- Arrays estructurales
- Arrays escalares
- Variables simples

Este proceso consume muchos recursos, de manera que recuperar simplemente los datos indispensables mejorará el rendimiento y consumo de los recursos.

### Comandos para crear, modificar o borrar entidades. 

- Se pueden crear las entidades con:
	```
	php vendor/doctrine/orm/bin/doctrine.php orm:schema-tool:create 
	```
- También se pueden borrar y crear de nuevo con:
	```
	php vendor/doctrine/orm/bin/doctrine.php orm:schema-tool:drop –force
	php vendor/doctrine/orm/bin/doctrine.php orm:schema-tool:create
	```
- Puedes actualizar las tablas con:
	```
	php vendor/doctrine/orm/bin/doctrine.php orm:schema-tool:update
	```

## Consultas

Hay 3 maneras para hacer las consultas:

- DQL (Doctrine Query Language): DQL Lenguaje específico para el entorno de Doctrine.
- Query Builder: Helper class para la construcción de consultas mediante una API.
- SQL Nativo: Uso de SQL propio de SGDB mediante NativeQuery o Query.

#### DQL
```
use Doctrine\Common\Cache\Psr6\DoctrineProvider;

$users = DoctrineProvider::getTable('User')->findAll();
foreach($users as $user) {
	echo $user->username . " has phonenumbers: ";
	foreach($user->Phonenumbers as $phonenumber) {
		echo $phonenumber->phonenumber . "\n";
	}
}
```

Ejemplo:
```
$query = $entityManager->createQuery('SELECT u FROM User u WHERE u.age > :age');
$query->setParameter('age', 18);

$users = $query->getResult();
```

#### Query Builder
Clase creada para ayudar a construir consultas SQL mediante uso de una interficie a través de una API.

Se crea mediante el método ```createQueryBuilder()```, heredado del repositorio base de la entidad o del <strong>EntityManager</strong>

En la creación de una instacia mediante createQueryBuilder, hemos de especificar un parámetro (string), alias de la otra entidad principal.
```
$qb=$entityRepo->createQueryBuilder(‘u’);
```

Equivale a la creación des de el EntityManager
```
$qb = $entityManager->createQueryBuilder();
$qb->select(‘u’);
```

También se puede obtener la consulta DQL generada por el QueryBuilder meditante getDQL()
```
$qb = $entityManager->createQueryBuilder();
$qb->select('p')->from('Cine\Entity\Pelicula','p');
$queryDQL = $qb->getDQL();
```

Se puede acceder también a SQL mediante getSQL()
```
$query = $qb->getQuery();
$querySQL = $query->getSQL();
```

Ejemplo de un ejercicio de clase:
```
$temesDQL = $entityManager->createQueryBuilder()
	->select('t')
	->from(Tema::class, 't')
	->join('t.frases', 'f')
	->groupBy('t.id');

$query = $temesDQL->getQuery()->getResult();
```

#### SQL Nativo

Los resultados se mapean a entidades Doctrine mediante ResultSetMapBuilder, se usa Doctrine ORM y solo soportan consulas SELECT.

Ejemplo de un ejercicio de clase:
```
$rsmb = new ResultSetMappingBuilder($entityManager);
$rsmb->addRootEntityFromClassMetadata('Frases\Entity\Tema', 't');

$sql = <<<SQL
	SELECT t.id, t.nombre, COUNT(ft.frase_id) as numFrases
	FROM tbl_tema t
	INNER JOIN tbl_frase_tema ft ON t.id = ft.tema_id
	GROUP BY t.id, t.nombre;
SQL;

$query = $entityManager->createNativeQuery($sql, $rsmb);
$result = $query->getResult();
```

Mi ejemplo del ejercicio de clase:
```
$sql = "SELECT t.nombre as 'nombreTema', COUNT(f.id) as 'numeroFrases'
	FROM tbl_tema t
	JOIN tema_frase tf ON t.id = tf.tema_id
	JOIN tbl_frases f ON tf.frase_id = f.id
	GROUP BY t.id";

$rsm = new \Doctrine\ORM\Query\ResultSetMappingBuilder($entityManager);
$rsm->addScalarResult('nombreTema', 'nombreTema');
$rsm->addScalarResult('numeroFrases', 'numeroFrases');

$query = $entityManager->createNativeQuery($sql, $rsm);
$result = $query->getResult();
```

## Repositoris

Cuando generamos una entidad, Doctrine nos proporciona un repositorio base por defecto para la entidad. Hay varios métodos para operar.

- <strong>find (id)</strong>: Devuelve la entidad con identificador id, null si no existe
- <strong>findAll ()</strong>: Devuelve un array con todas las entidades del repository
- <strong>findBy (array (criteris) [, array (a ordenació)])</strong>: Devuelve un array con las entidades que cumplen los criterios especificados en el primer parámetro y ordenados por el segundo parámetro (opcional este último).
- <strong>findOneBy (array (criteris))</strong>: Parecido a findBy, pero devuelve solo un elemento (objeto) o nulo si no lo encuentra.

Algunos metodos del repositorio base se pueden usar de manera simple, sin tener que especificar como parámetro el nombre de la propiedad. 

Ejemplo:
```
findByTitulo(‘valor’)
findOneByTitulo(‘valor’)
```

Esto es gracias al método __call() de PHP, por este motivo no se puede usar este método si estamos usando Doctrine. 

El repositorio base se puede extender en una nueva clase para proporcionar metodos especificos para consultas más específicas. Permite optimizar la obtención de resultados, más control en la hidratación de los datos (Seleccionar parcialmente entidades o especificar operaciones que no se podrían hacer de manera automática).

Para especificar la clase exacta que usaremos como repository, usaremos la anotacion ```@Entity```
```
@Entity(repositoryClass=“FilmRepository”)
```

Para generar este repositorio automáticamente desde consola, se puede hacer con un comando, esto apunta al archivo doctrine.php, pero dependiendo de la versión de doctrine, ese archivo está en una ruta u otra.

- ``` php vendor/bin/doctrine.php orm:generate-repositories /src```
- ``` php vendor/doctrine/orm/bin/doctrine.php orm:generate-repositories src/``` (este es el que me funciona)
