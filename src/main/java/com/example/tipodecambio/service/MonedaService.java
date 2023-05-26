package com.example.tipodecambio.service;

import com.example.tipodecambio.model.Moneda;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MonedaService {

    private final Map<String, Moneda> moneda;

    public MonedaService(){
        moneda = new HashMap<String, Moneda>();

        moneda.put("MXN", new Moneda("MXN", "1"));
        moneda.put("USD", new Moneda("Dollar", "3.5"));
        moneda.put("EUR", new Moneda("Euro", "4.2"));

    }

    public boolean exists(String name){
        return moneda.containsKey(name.toUpperCase());
    }

    public String[] getAll() {
        return moneda.keySet().toArray(new String[moneda.size()]);
    }

    public Moneda getByCodigo(String codigo) {
        return moneda.get(codigo);
    }

}
