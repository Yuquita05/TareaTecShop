# TareaTecShop

Yunier Obando Arias

#S1
Promp #1
User:
CONTEXTO: Toma shipping service
TAREA: Crea una clase EnvioCorreos
ESTRUCTURA: Implementa shipping provider, EnvioCorreos solo debe tener un atributo private final correosApi
REGLAS: NO debe cambiar no modifiques CorreosApi
sin librerías nuevas; mantener el paquete tecshop; no tocar otros archivos.
TERMINADO: Compila; Main imprime exactamente la salida base;
mostrame solo el archivo nuevo/modificado.

````

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
````

Promp #2

User:
CONTEXTO: Toma shipping service, enviocorreos y correos api
TAREA: crea un objeto tipo EnvioCorreos en shipping service y reemplaza el quote de shipping service con el quote de enviocorres

REGLAS: Qué NO debe cambiar (p. ej. "no modifiques CorreosApi");
sin librerías nuevas; mantener el paquete tecshop; no tocar otros archivos.
TERMINADO: Compila; Main imprime exactamente la salida base;
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

CONTEXTO: toma cartitem
TAREA: crea una clase ProductoCompleto que herede de cartitem
ESTRUCTURA: tiene un private boolean engraving, crea su metodo constructor con super de cartitem, sobreescribe los metodos getPrice y describe en ProductoCompleto usando el super de cartitem
REGLAS: Qué NO debe cambiar (p. ej. "no modifiques CorreosApi");
sin librerías nuevas; mantener el paquete tecshop; no tocar otros archivos.
TERMINADO: Compila; Main imprime exactamente la salida base;
mostrame solo el archivo nuevo/modificado.

package tecshop;

public class ProductoCompleto extends CartItem {
private boolean engraving;

    public ProductoCompleto(String name, double basePrice, boolean giftWrap, boolean insurance,
            boolean express, boolean engraving) {
        super(name, basePrice, giftWrap, insurance, express);
        this.engraving = engraving;
    }

    @Override
    public double getPrice() {
        double price = super.getPrice();
        if (engraving) {
            price += 3000;
        }
        return price;
    }

    @Override
    public String describe() {
        String text = super.describe();
        if (engraving) {
            text += " + engraving";
        }
        return text;
    }

}

Promp #2

CONTEXTO: toma main y producto completo
TAREA: reemplaza los new cartitem por new producto completo
ESTRUCTURA: Nombre del tipo; qué implementa/extiende; atributos (¿private? ¿final?);
parámetros del constructor; firmas de métodos; a qué objeto delega
cada método y qué hace antes/después de delegar.
REGLAS: Qué NO debe cambiar (p. ej. "no modifiques CorreosApi");
sin librerías nuevas; mantener el paquete tecshop; no tocar otros archivos.
TERMINADO: Compila; Main imprime exactamente la salida base;
mostrame solo el archivo nuevo/modificado.

package tecshop;

public class ProductoCompleto extends CartItem {
private final boolean engraving;

    public ProductoCompleto(String name, double basePrice, boolean giftWrap, boolean insurance,
            boolean express, boolean engraving) {
        super(name, basePrice, giftWrap, insurance, express);
        this.engraving = engraving;
    }

    @Override
    public double getPrice() {
        double price = super.getPrice();
        if (engraving) {
            price += 3000;
        }
        return price;
    }

    @Override
    public String describe() {
        String text = super.describe();
        if (engraving) {
            text += " + engraving";
        }
        return text;
    }

}

## S3: Checkouts duplicados (WebCheckout y KioskCheckout)

Integrante: Keyzel Segura Quesada

### Detección (sin IA)

- **Dónde:** WebCheckout.buy y KioskCheckout.buy
- **Síntoma:** si cambia un paso de la compra, hay que editarlo en las dos
  clases; si se olvida una, web y kiosco se comportan distinto.
- **Quién sabe demasiado:** cada checkout conoce y crea todos los servicios
  (Inventory, TaxCalculator, ShippingService, PaymentGateway, InvoicePrinter).
- **Qué quedaría intacto:** Inventory, TaxCalculator, ShippingService,
  PaymentGateway, InvoicePrinter y Money.

### Prompt 1

CONTEXTO: Te paso WebCheckout.java, KioskCheckout.java y ShippingService.java.
Los dos checkouts repiten los mismos 6 pasos en buy(); solo cambian el proveedor
de envío ("correos" o "local") y el método de pago ("credit card" o "SINPE Movil").
TAREA: Creá una clase nueva CheckoutService en el paquete tecshop.
ESTRUCTURA: Tiene dos atributos private final String: shippingProvider y
paymentMethod, que recibe en el constructor. Tiene un método
public void buy(Cart cart, String customer, String city) que hace los mismos 6
pasos de WebCheckout, en el mismo orden: reservar en Inventory, calcular el
subtotal y el impuesto con TaxCalculator, cotizar el envío con ShippingService
usando shippingProvider, sumar el total, cobrar con PaymentGateway usando
paymentMethod, e imprimir con InvoicePrinter. Crea Inventory, TaxCalculator,
ShippingService, PaymentGateway e InvoicePrinter ella misma.
REGLAS: No modifiques WebCheckout, KioskCheckout ni ninguna otra clase. Sin
librerías nuevas. Mantené el paquete tecshop.
TERMINADO: Compila. Main imprime exactamente la salida base. Mostrame solo el
archivo nuevo.
**Resultado:** Creó solo el archivo CheckoutService.java, con los dos atributos
private final String (shippingProvider y paymentMethod), el constructor y el
método buy con los 6 pasos en el orden de WebCheckout. No modificó ningún
archivo existente (git status solo mostró archivos nuevos). Compiló y la salida
fue idéntica a la base. Intentó ejecutar un comando en la terminal por su
cuenta y lo rechacé para compilar y comparar yo mismo.

### Prompt 2

CONTEXTO: Te paso WebCheckout.java y CheckoutService.java.
TAREA: Cambiá WebCheckout para que use CheckoutService.
ESTRUCTURA: WebCheckout tiene un atributo private final CheckoutService service =
new CheckoutService("correos", "credit card"). El método buy(Cart cart, String
customer, String city) queda con una sola línea que llama a service.buy(cart,
customer, city). Borrá el resto del cuerpo.
REGLAS: No modifiques CheckoutService ni otros archivos. Sin librerías nuevas.
Mantené el paquete tecshop.
TERMINADO: Compila. Main imprime exactamente la salida base. Mostrame solo el
archivo modificado.
**Resultado:** Reemplazó el cuerpo de buy por una sola llamada a service.buy(cart, customer, city) y agregó el atributo service con ‘correos’ y ‘credit card’. Solo tocó WebCheckout.java (+3 -16). La salida coincide con la base

### Prompt 3

CONTEXTO: Te paso KioskCheckout.java y CheckoutService.java.
TAREA: Cambiá KioskCheckout para que use CheckoutService.
ESTRUCTURA: KioskCheckout tiene un atributo private final CheckoutService service =
new CheckoutService("local", "SINPE Movil"). El método buy(Cart cart, String
customer, String city) queda con una sola línea que llama a service.buy(cart,
customer, city). Borrá el resto del cuerpo.
REGLAS: No modifiques CheckoutService ni otros archivos. Sin librerías nuevas.
Mantené el paquete tecshop.
TERMINADO: Compila. Main imprime exactamente la salida base. Mostrame solo el
archivo modificado.
**Resultado:** Reemplazó el cuerpo de buy por una sola llamada a service.buy y agregó el atributo service con ‘local’ y ‘SINPE Movil’. Solo tocó KioskCheckout.java. La salida de Luis coincide con la base.

### Verificación final

- [ ] WebCheckout y KioskCheckout quedaron con una sola llamada cada uno
- [ ] Los checkouts ya no crean Inventory, TaxCalculator, etc.
- [ ] Las clases de servicios quedaron sin cambios
- [ ] La salida coincide con la salida base
