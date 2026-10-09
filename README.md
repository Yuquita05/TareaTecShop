# TareaTecShop

#S1
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


#S2

Promp #1

CONTEXTO: Toma cartitem
TAREA: crea una interfaz iExtras que sea implementada por cartitem
ESTRUCTURA: la interfaz solo debe tener los metodos getPrice y describe
REGLAS: Qué NO debe cambiar (p. ej. "no modifiques CorreosApi");
sin librerías nuevas; mantener el paquete tecshop; no tocar otros archivos.
TERMINADO: Compila; Main imprime exactamente la salida base;
mostrame solo el archivo nuevo/modificado.


package tecshop;

public interface iExtras {
    double getPrice();
    String describe();
}

package tecshop;

public class CartItem implements iExtras {
    private final String name;
    private final double basePrice;
    private final boolean giftWrap;
    private final boolean insurance;
    private final boolean express;

    // TODO: marketing wants 4 more extras next sprint:
    //       engraving, eco-packaging, extended warranty, priority support...
    public CartItem(String name, double basePrice, boolean giftWrap, boolean insurance, boolean express) {
        this.name = name;
        this.basePrice = basePrice;
        this.giftWrap = giftWrap;
        this.insurance = insurance;
        this.express = express;
    }

    public double getPrice() {
        double price = basePrice;
        if (giftWrap) {
            price += 1500;
        }
        if (insurance) {
            price += price * 0.05;
        }
        if (express) {
            price += 2500;
        }
        return price;
    }

    public String describe() {
        String text = name;
        if (giftWrap) {
            text += " + gift wrap";
        }
        if (insurance) {
            text += " + insurance";
        }
        if (express) {
            text += " + express";
        }
        return text;
    }
}

Promp #2

CONTEXTO: Toma cartitem y iExtras
TAREA: Crea una clase Extras que implemente iExtras
ESTRUCTURA: Tiene private final engraving
REGLAS: Qué NO debe cambiar (p. ej. "no modifiques CorreosApi");
sin librerías nuevas; mantener el paquete tecshop; no tocar otros archivos.
TERMINADO: Compila; Main imprime exactamente la salida base;
mostrame solo el archivo nuevo/modificado.


package tecshop;

public class Extras implements iExtras {
    private final iExtras engraving;

    public Extras(iExtras engraving) {
        this.engraving = engraving;
    }

    @Override
    public double getPrice() {
        return engraving.getPrice() + 3000;
    }

    @Override
    public String describe() {
        return engraving.describe() + " + engraving";
    }
}


