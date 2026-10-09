# TareaTecShop

Promp #1
User: 
CONTEXTO:  Toma shipping service
TAREA:     Crea una clase EnvioCorreos
ESTRUCTURA:  Implementa shipping provider, EnvioCorreos solo debe tener un atributo private final correosApi
REGLAS: NO debe cambiar no modifiques CorreosApi
             sin librerías nuevas; mantener el paquete tecshop; no tocar otros archivos.
TERMINADO:   Compila; Main imprime exactamente la salida base;
             mostrame solo el archivo nuevo/modificado.
```

Copilot: Read [](file:///c%3A/Users/oband/Desktop/poo/cursostec/poo/src/patterns/tecshop/ShippingProvider.java), lines 1 to 200
Completed with input: {
  "path": "c:\\Users\\oband\\Desktop\\poo\\cursostec\\poo\\src\\patterns\\tecshop\\ShippingProvider.java",
  "view_range": [
    1,
    200
  ]
}

Read [](file:///c%3A/Users/oband/Desktop/poo/cursostec/poo/src/patterns/tecshop/CorreosApi.java), lines 1 to 200
Completed with input: {
  "path": "c:\\Users\\oband\\Desktop\\poo\\cursostec\\poo\\src\\patterns\\tecshop\\CorreosApi.java",
  "view_range": [
    1,
    200
  ]
}

Read [](file:///c%3A/Users/oband/Desktop/poo/cursostec/poo/src/patterns/tecshop/ShippingService.java), lines 1 to 200
Completed with input: {
  "path": "c:\\Users\\oband\\Desktop\\poo\\cursostec\\poo\\src\\patterns\\tecshop\\ShippingService.java",
  "view_range": [
    1,
    200
  ]
}

Read [](file:///c%3A/Users/oband/Desktop/poo/cursostec/poo/src/patterns/tecshop), lines 1 to 200
Completed with input: {
  "path": "c:\\Users\\oband\\Desktop\\poo\\cursostec\\poo\\src\\patterns\\tecshop",
  "view_range": [
    1,
    200
  ]
}

Read [](file:///c%3A/Users/oband/Desktop/poo/cursostec/poo/src/patterns/tecshop/Main.java), lines 1 to 200
Completed with input: {
  "path": "c:\\Users\\oband\\Desktop\\poo\\cursostec\\poo\\src\\patterns\\tecshop\\Main.java",
  "view_range": [
    1,
    200
  ]
}

Read [](file:///c%3A/Users/oband/Desktop/poo/cursostec/poo/src/patterns/tecshop/LocalCourier.java), lines 1 to 200
Completed with input: {
  "path": "c:\\Users\\oband\\Desktop\\poo\\cursostec\\poo\\src\\patterns\\tecshop\\LocalCourier.java",
  "view_range": [
    1,
    200
  ]
}

Create [](file:///c%3A/Users/oband/Desktop/poo/cursostec/poo/src/patterns/tecshop/EnvioCorreos.java)

Ran terminal command: cd "c:\Users\oband\Desktop\poo\cursostec\poo"; javac -d out src/patterns/tecshop/*.java; java -cp out tecshop.Main

```java
package tecshop;

public class EnvioCorreos implements ShippingProvider {
    private final CorreosApi correosApi;

    public EnvioCorreos() {
        this.correosApi = new CorreosApi();
    }

    @Override
    public double quote(double kg, String city) {
        int gramos = (int) Math.round(kg * 1000);
        String codigoPostal;
        switch (city) {
            case "San Jose":
                codigoPostal = "10101";
                break;
            case "Alajuela":
                codigoPostal = "20101";
                break;
            case "Cartago":
                codigoPostal = "30101";
                break;
            case "Limon":
                codigoPostal = "70101";
                break;
            default:
                throw new IllegalArgumentException("Unknown city: " + city);
        }

        String raw = correosApi.calcularTarifa(gramos, codigoPostal);
        return Double.parseDouble(raw.replace("₡", ""));
```

Promp #2



User: 
CONTEXTO:    Toma shipping service, enviocorreos y correos api
TAREA:  crea un objeto tipo EnvioCorreos en shipping service y reemplaza el quote de shipping service con el quote de enviocorres

REGLAS:      Qué NO debe cambiar (p. ej. "no modifiques CorreosApi");
             sin librerías nuevas; mantener el paquete tecshop; no tocar otros archivos.
TERMINADO:   Compila; Main imprime exactamente la salida base;
             mostrame solo el archivo nuevo/modificado.

```
Copilot: Read , lines 1 to 200
Completed with input: {
  "path": "c:\\Users\\oband\\Desktop\\poo\\cursostec\\poo\\src\\patterns\\tecshop\\ShippingService.java",
  "view_range": [
    1,
    200
  ]
}

Edit 

Ran terminal command: cd "c:\Users\oband\Desktop\poo\cursostec\poo"; javac -d out src/patterns/tecshop/*.java; java -cp out tecshop.Main

java
package tecshop;

public class ShippingService {
    private final LocalCourier local = new LocalCourier();
    private final EnvioCorreos correos = new EnvioCorreos();

    public double quote(String provider, double kg, String city) {
        if (provider.equals("local")) {
            return local.quote(kg, city);
        } else if (provider.equals("correos")) {
            return correos.quote(kg, city);
        }
        throw new IllegalArgumentException("Unknown provider: " + provider);
    }
}
```
