    import com.google.gson.Gson;
    import com.google.gson.GsonBuilder;

    import java.io.IOException;
    import java.net.URI;
    import java.net.http.HttpClient;
    import java.net.http.HttpRequest;
    import java.net.http.HttpResponse;
    import java.util.Scanner;

    public class Principal {


        public static void main(String[] args) {
            int opcion;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/a07f555b467d5168b731c7f3/latest/USD"))
                    .build();
            Scanner teclado= new Scanner(System.in);
            Gson gson=new GsonBuilder().setPrettyPrinting().create();
            Conversor conversor=new Conversor();


            do {
                {
                    try {
                        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                        String json = response.body();
                        RespuestaApi respuesta = gson.fromJson(json, RespuestaApi.class);
                        Moneda monedasTransformadas = respuesta.conversionRates();
//                        System.out.println(monedasTransformadas);
//                        System.out.println(monedasTransformadas.getARS());


                        System.out.println("""
                                *************************************************
                                Sea bienvenido/a al Conversor de Monedas =]
                                                            
                                1) Dolar => Peso argentino
                                2) Peso argentino => Dolar
                                3) Dolar => Real brasileño
                                4) Real brasileño => Dolar
                                5) Dolar => Peso colombiano
                                6) Peso colombiano => Dolar
                                7) Salir
                                **************************************************""");
                        System.out.print("Elija una opcion valida: ");
                        opcion = teclado.nextInt();
                        double valor, resultado;
                        switch (opcion) {
                            case 1:
                                System.out.print("Ingrese el valor que desee convertir: ");
                                valor = teclado.nextDouble();
                                resultado = conversor.convertirMoneda(valor, monedasTransformadas.getARS());
                                System.out.println("\nEl valor "+valor+" [USD] equivale a "+resultado+" [ARS]\n");
                                break;
                            case 2:
                                System.out.print("Ingrese el valor que desee convertir: ");
                                valor = teclado.nextDouble();
                                resultado = conversor.convertirMoneda2(valor, monedasTransformadas.getARS());
                                System.out.println("\nEl valor "+valor+" [ARS] equivale a "+resultado+" [USD]\n");
                                break;

                            case 3:
                                System.out.print("Ingrese el valor que desee convertir: ");
                                valor = teclado.nextDouble();
                                resultado = conversor.convertirMoneda(valor, monedasTransformadas.getBRL());
                                System.out.println("\nEl valor "+valor+" [USD] equivale a "+resultado+" [BRL]\n");
                                break;
                            case 4:
                                System.out.print("Ingrese el valor que desee convertir: ");
                                valor = teclado.nextDouble();
                                resultado = conversor.convertirMoneda2(valor, monedasTransformadas.getBRL());
                                System.out.println("\nEl valor "+valor+" [BRL] equivale a "+resultado+" [USD]\n");
                                break;
                            case 5:
                                System.out.print("Ingrese el valor que desee convertir: ");
                                valor = teclado.nextDouble();
                                resultado = conversor.convertirMoneda(valor, monedasTransformadas.getCOP());
                                System.out.println("\nEl valor "+valor+" [USD] equivale a "+resultado+" [COP]\n");
                                break;
                            case 6:
                                System.out.print("Ingrese el valor que desee convertir: ");
                                valor = teclado.nextDouble();
                                resultado = conversor.convertirMoneda2(valor, monedasTransformadas.getCOP());
                                System.out.println("\nEl valor "+valor+" [COP] equivale a "+resultado+" [USD]\n");
                                break;

                            case 7:
                                break;

                            default:
                                System.out.println("Esa opcion está disponible.");
                        }

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }while (opcion!=7);

            System.out.println("Fin del programa.");
        }


    }
