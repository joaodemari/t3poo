package dados.Colecao;

import java.util.ArrayList;

import dados.events.Event;

public class ColecaoEvents extends ArrayList<Event> {
    
    public ColecaoEvents() {
        super();
    }

    public void adicionarEvent(Event event) {
        this.add(event);
    }

    public void removerEvent(Event event) {
        this.remove(event);
    }

    public String[] toCodigoArray() {
        String[] codigo = new String[this.size()];
        for (int i = 0; i < this.size(); i++) {
            codigo[i] = this.get(i).getCodigo();
        }
        return codigo;
    }

    public Event getEventByCodiigo(String code) {
        for (Event event : this) {
            if (event.getCodigo().toLowerCase().contains(code.toLowerCase())) {
                return event;
            }
        }
        return null;
    }

    public String[][] toMatrix() {
        String[][] eventsArray = new String[this.size()][4];
        for (int i = 0; i < this.size(); i++) {
            eventsArray[i][0] = this.get(i).getCodigo();
            eventsArray[i][1] = String.valueOf(this.get(i).getData());
            eventsArray[i][2] = String.valueOf(this.get(i).getLatitude());
            eventsArray[i][3] = String.valueOf(this.get(i).getLongitude());
        }
        return eventsArray;
    }

    public boolean codigoExists(String code) {
        for (Event event : this) {
            if (event.getCodigo().equals(code)) {
                return true;
            }
        }
        return false;
    }
    
}
