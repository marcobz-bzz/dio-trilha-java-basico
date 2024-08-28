package br.edu.dio.map;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {
    private HashMap<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        eventosMap = new HashMap<>();
    }

    public void adicionarEvento(LocalDate data, String nome, String atracao) {
        eventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda() {
        if (eventosMap.isEmpty()) {
            System.out.println(">>> agenda vazia <<<");
        }

        TreeMap<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        for (Map.Entry<LocalDate, Evento> ee : eventosTreeMap.entrySet()) {
            System.out.println((ee.getKey() == null ? "--" : ee.getKey())
                    + " == " + (ee.getValue() == null ? "--" : ee.getValue()));
        }
        // System.out.println(eventosTreeMap);
    }

    // public Evento obterProximoEvento() {
    // if (eventosMap.isEmpty())
    // return null;
    // LocalDate dataEvento = null;
    // long eventoDia = Long.MAX_VALUE;
    // long hojeDia = LocalDate.now().toEpochDay();
    // for (LocalDate dd : eventosMap.keySet()) {
    // if (dataEvento == null) {
    // dataEvento = dd;
    // continue;
    // }
    // if (dd == null)
    // continue;
    // if(dd.toEpochDay() >= hojeDia && dd.toEpochDay() < eventoDia){
    // eventoDia = dd.toEpochDay();
    // dataEvento = dd;
    // }
    // }
    // return eventosMap.get(dataEvento);
    // }

    public Evento obterProximoEvento() {
        if (eventosMap.isEmpty())
            return null;

        Evento proximoEvento = null;
        LocalDate hoje = LocalDate.now();
        TreeMap<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        for (LocalDate dd : eventosTreeMap.keySet()) {
            if (dd.isEqual(hoje) || dd.isAfter(hoje)) {
                proximoEvento = eventosMap.get(dd);
                break;
            }
        }

        return proximoEvento;
    }

}
