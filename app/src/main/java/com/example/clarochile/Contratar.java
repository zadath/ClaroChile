package com.example.clarochile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.nio.ByteBuffer;

import static com.example.clarochile.sharedpreferences.UserSharedPreferences.prefs;

public class Contratar extends AppCompatActivity {

    private Button btnEjecutar, btnResumen;
    String RutCliente, mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contratar);

        btnEjecutar = (Button) findViewById(R.id.btnEjecutar);
        btnResumen = (Button) findViewById(R.id.btn_resumenVenta);

        btnEjecutar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contratar.SegundoPlano tarea = new Contratar.SegundoPlano();
                tarea.execute();
            }
        });

        btnResumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Contratar.this, ResumenVenta.class);
                //startActivity(intent);

            }
        });

    }
    public class SegundoPlano extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            System.out.println("Entré a la clase CONTRATAR ");
            //consultar();
            return null;
        }
    }

    public String consultar(String xmlRespuesta) {
        //String xmlRespuesta = "";
        String rut = prefs.getRut();
        System.out.println("Entré a la clase CONTRATAR 2");
        // Se obtienen los datos del formulario
        //edRutCliente = (EditText) findViewById(R.id.etRutCliente);
        //RutCliente = edRutCliente.getText().toString().trim();
       // RutCliente = "13491301-0";
        //RutCliente = "19678834-4";
        //RutCliente = "16144162-7";
        //RutCliente = "20816218-7";
        //RutCliente = "22164414-k";
        //RutCliente = "22828946-9";
        //RutCliente = "17496429-7";
        //RutCliente = "7345415-8";
        //RutCliente = "5135127-4";
        //RutCliente = "17031971-0";
        //RutCliente = "18138239-2";   // El cliente ya existe
        //RutCliente = "13576759-k";  // Referencia no valida
        //RutCliente = "9012525-7";  //
        RutCliente = rut;  //

        //Se arma la petición
        String SOAP_ACTION = "";
        String METHOD_NAME = "conectaSUR";
        String NAMESPACE = "http://cecliente.org";
        String URL = "http://10.94.200.6/zntapp_gestion/services/ConexionClienteBST?wsdl";

        //Objetos para el Request
        SoapObject infoCliente = new SoapObject();
        SoapObject solicitud = new SoapObject();
        SoapObject cuentas = new SoapObject();
        SoapObject domicilioDeInstalacion = new SoapObject();
        SoapObject domicilio = new SoapObject();
        SoapObject contratos = new SoapObject();
        SoapObject datosVenta = new SoapObject();
        SoapObject agendacion = new SoapObject();
        SoapObject combos = new SoapObject();
        SoapObject servicio = new SoapObject();
        SoapObject itemDeTagServicio = new SoapObject();
        SoapObject servicioPpal = new SoapObject();
        SoapObject servicioAdicional = new SoapObject();
        SoapObject item = new SoapObject();
        SoapObject servicioBase = new SoapObject();
        SoapObject servicioPpalAdicional = new SoapObject();
        SoapObject productos = new SoapObject();

        /*
        SoapObject domicilioDeEnvio = new SoapObject();
        SoapObject domicilioDeFacturacion = new SoapObject();
        //SoapObject servicioBase = new SoapObject(NAMESPACE, METHOD_NAME_servicioBase);
        //SoapObject item = new SoapObject(NAMESPACE, METHOD_NAME_item);
        //SoapObject servicioPpal = new SoapObject(NAMESPACE, METHOD_NAME_servicioPpal);
        SoapObject contactos = new SoapObject();*/

        /*Cliente cliente = new Cliente();
        DatosCliente datosCliente = new DatosCliente();
        Cuenta cuenta = new Cuenta();
        //Domicilio domicilio = new Domicilio();
        DomicilioInstalacion domicilioInstalacion = new DomicilioInstalacion();
        Contactos contactos = new Contactos();
        Agendacion agendacion = new Agendacion();
        BOServicio servicio = new BOServicio();
        BOProductos productos = new BOProductos();
        ArrayOfContacto arrayOfContacto = new ArrayOfContacto();
        BOServicioBase servicioBase = new BOServicioBase();
        ArrayOfBOServicioBase arrayOfBOServicioBase = new ArrayOfBOServicioBase();
        ArrayOfBOServicio arrayOfBOServicio = new ArrayOfBOServicio();
        BOCombo combo = new BOCombo();
        Contrato contrato = new Contrato();
        DatosVenta datosVenta = new DatosVenta();*/


        // infoCliente
        infoCliente.addProperty("apellidoMaterno", "Ibarras");
        infoCliente.addProperty("apellidoPaterno", "Guevaras");
        infoCliente.addProperty("claveCategoria", "norm");
        infoCliente.addProperty("claveTipoCliente", "1");
        infoCliente.addProperty("edad", "17");
        infoCliente.addProperty("email", "zadath577@gmail.com");
        infoCliente.addProperty("fechaAlta", "20200705170000");
        infoCliente.addProperty("iwIdEmpresa", "119");
        infoCliente.addProperty("nombre", "Sadat");
        infoCliente.addProperty("razonSocial", "");
        infoCliente.addProperty("referencia", RutCliente);
        infoCliente.addProperty("sexo", "");

        //agendacion
        agendacion.addProperty("claveTipoInstalacion", "N");
        agendacion.addProperty("cveAliado", "OMEGA");
        agendacion.addProperty("cveTecnico", "301905-5");
        agendacion.addProperty("fechaEntrega", "30042020");
        agendacion.addProperty("horaEntrega", "");
        agendacion.addProperty("nomContacto", "Prueba SADAT");
        agendacion.addProperty("observaciones", "observaciones");
        agendacion.addProperty("telCotnacto", "123456789");
        agendacion.addProperty("tiempoPromInst", " ");

        //datosVenta
        datosVenta.addProperty("claveAgente", "000000000T");
        datosVenta.addProperty("claveTipoVenta", "2");
        datosVenta.addProperty("claveVendedor", "000000000T");
        datosVenta.addProperty("idMov", "1");
        datosVenta.addProperty("tipiMov", "1");
        datosVenta.addProperty("tipoVenta", "TERRENO");

        // servicioBase
        servicioBase.addProperty("accion", "ALTA");
        servicioBase.addProperty("clave", "tvh_prh001");
        servicioBase.addProperty("descripcion", "TV Pro HD 12-2017");
        servicioBase.addProperty("grupo", "tv_paq");
        servicioBase.addProperty("precio", 21490);  //apagado temporal porque arroja error de "Type mismatch"

        // servicioAdicional
        //servicioAdicional.addProperty("item", "");   // Al parecer puede ir vacío, validemos!

        // servicioPpalAdicional, al parecer puede ir vacío... validemos!
        //servicioPpalAdicional.addProperty("item", "");


        // item  :: este es el agrupador de servicioBase y servicioAdicional
        item.addProperty("servicioBase", servicioBase);                //apagado temp
        //item.addProperty("servicioAdicional", servicioAdicional);     //apagado temp

        // servicioPpal, este agrupará a item
        servicioPpal.addProperty("item", item);                       //apagado Temp


        // itemDeTagServicio
        itemDeTagServicio.addProperty("servicioPpal", servicioPpal);
        itemDeTagServicio.addProperty("servicioPpalAdicional", servicioPpalAdicional);
        itemDeTagServicio.addProperty("tecnologia", "HFC");
        itemDeTagServicio.addProperty("tipo", "TV");

        //servicio
        servicio.addProperty("item", itemDeTagServicio);

        //productos
        //productos.addProperty("producto","");

        // Combos
        combos.addProperty("accion", "ALTA");
        combos.addProperty("clave", "1ph1117_05");
        combos.addProperty("descripcion", "1Play Hogar TV Pro HD");
        combos.addProperty("grupo", "com_op");
        combos.addProperty("servicio", servicio);
        combos.addProperty("productos", productos);

        //contratos
        contratos.addProperty("accion", "ALTA");
        contratos.addProperty("agendacion", agendacion);
        contratos.addProperty("combos", combos);
        contratos.addProperty("datosVenta", datosVenta);

        // domicilio
        domicilio.addProperty("claveComuna", "LCO");
        domicilio.addProperty("claveRegion", "RMS");
        domicilio.addProperty("localidad", "");
        domicilio.addProperty("observaciones", "");
        domicilio.addProperty("sam", "1002");
        domicilio.addProperty("subnumero", "");

        //domicilioDeInstalacion
        domicilioDeInstalacion.addProperty("accion", "ALTA");
        //domicilioDeInstalacion.addProperty("contactos", contactos);
        domicilioDeInstalacion.addProperty("contratos", contratos);
        domicilioDeInstalacion.addProperty("domicilio", domicilio);

        // cuentas
        cuentas.addProperty("accion", "ALTA");
        cuentas.addProperty("alias", "CTA PRINCIPAL");
        cuentas.addProperty("cicloFac", "40");
        cuentas.addProperty("cveGiroCte", "comunica");
        cuentas.addProperty("diaInicioPer", "1");
        /*cuentas.addProperty("domicilioDeEnvio", domicilioDeEnvio);
        cuentas.addProperty("domicilioDeFacturacion", domicilioDeFacturacion);*/
        cuentas.addProperty("domicilioDeInstalacion", domicilioDeInstalacion);

        //Armado de solicitud y request
        SoapObject Request = new SoapObject(NAMESPACE, METHOD_NAME);

        solicitud.addProperty("accion", "ALTA");
        solicitud.addProperty("compania", "1");
        solicitud.addProperty("infoCliente", infoCliente);
        solicitud.addProperty("cuentas", cuentas);
        Request.addProperty("solicitud", solicitud);


        System.out.println("El rut DEL CLIENTE es: " + RutCliente);
        SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapEnvelope.dotNet = true;
        soapEnvelope.setOutputSoapObject(Request);
        HttpTransportSE transport = new HttpTransportSE(URL);
        transport.debug = true;

        try{
            transport.call(SOAP_ACTION, soapEnvelope);
            //objeto = (SoapObject) soapEnvelope.getResponse();
            // resultString = soapEnvelope.bodyIn.toString();
            Log.d("Ejecución exitosa", "se realizó la petición");
        } catch (Exception ex){
            mensaje  = "Error:"+ex.getMessage();
        }

        xmlRespuesta = transport.responseDump;
        //salida = xmlRespuesta;
        //System.out.println("SOAP Request " + transport.requestDump);
        //System.out.println("SOAP Response " + transport.responseDump);
        System.out.println("_Saliendo de la clase Contratar ");
        //System.out.println("xmlRespuesta =  " + xmlRespuesta);
        return xmlRespuesta;
    }
}