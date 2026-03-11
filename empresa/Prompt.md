Prompt para generar código Java (Proyecto tipo Empresa)

Hola ChatGPT.

Voy a darte un enunciado de un ejercicio de programación en Java.
Quiero que generes todo el código necesario para resolverlo siguiendo una estructura concreta de proyecto.

Estoy estudiando 1º de DAM (Desarrollo de Aplicaciones Multiplataforma), así que el código debe ser claro, sencillo y fácil de entender.

Requisitos generales

El código debe:

Estar escrito en Java 21

Usar Programación Orientada a Objetos (POO)

Seguir una arquitectura organizada por paquetes

Incluir excepciones personalizadas

Usar logs con SLF4J y Log4j

Usar Lombok cuando sea útil (por ejemplo @Getter, @Setter, @AllArgsConstructor, @NoArgsConstructor)

Importante:

❌ NO generes:

pom.xml

configuración de Log4j

archivos de configuración de logs

Solo quiero que implementes los logs en el código, porque yo ya tengo esos archivos en mi proyecto y los copiaré.

Estructura del proyecto (OBLIGATORIA)

Debes organizar el código exactamente así:

src/main/java/org/ies/interno/company

apps
CompanyApp

exceptions
CustomException

model
EntidadPrincipal
EntidadSecundaria

reader
EntidadReader
Reader

Main
Explicación de cada paquete
model

Aquí van las clases del dominio del ejercicio.

Por ejemplo:

Employee

Department

Company

Product

Order

Las clases deben tener:

atributos privados

constructores

getters y setters (preferiblemente con Lombok)

toString()

métodos de lógica si son necesarios

Ejemplo de estructura:

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private String name;
    private int age;
}
reader

Este paquete contiene clases que leen datos o crean objetos.

Ejemplos:

EmployeeReader

DepartmentReader

CompanyReader

Estas clases pueden:

leer datos

crear objetos

validar información

lanzar excepciones si algo está mal

exceptions

Aquí deben ir las excepciones personalizadas del ejercicio.

Ejemplos:

EmployeeNotFoundException

InvalidDepartmentException

Las excepciones deben extender de:

Exception

o

RuntimeException

Incluye constructores con mensajes de error.

apps

Aquí va la lógica principal del programa.

Ejemplo:

CompanyApp

Esta clase debe:

usar las clases del modelo

usar los readers

manejar excepciones

contener la lógica principal del ejercicio

Main

Debe existir una clase:

Main

Con el método:

public static void main(String[] args)

Desde aquí se debe iniciar la aplicación, normalmente llamando a CompanyApp.

Uso de logs

Debes usar SLF4J con Log4j en las clases importantes.

Ejemplo:

private static final Logger log = LoggerFactory.getLogger(ClassName.class);

Ejemplos de logs:

log.info("Inicio de la aplicación");
log.warn("Dato incorrecto detectado");
log.error("Error al procesar los datos");

Usa logs en:

inicio de procesos

errores

advertencias

acciones importantes

⚠️ No generes archivos de configuración de logs. Solo usa los logs en el código.

Reglas al generar el código

Cuando te dé el ejercicio debes:

Crear todas las clases necesarias

Organizar correctamente los paquetes

Usar POO correctamente

Usar excepciones personalizadas

Añadir logs en partes importantes

Hacer el código claro y fácil de entender

Pensar que lo va a leer un estudiante de primero de DAM

Cómo quiero que me entregues el resultado

Quiero que muestres el código por archivos, por ejemplo:

model/Employee.java

(código)

reader/EmployeeReader.java

(código)

etc.

Enunciado del ejercicio

Aquí te pondré el ejercicio que quiero que resuelvas:

AQUÍ PEGARÉ EL ENUNCIADO