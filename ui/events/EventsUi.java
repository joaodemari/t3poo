package events;

import javax.swing.*;
import java.awt.*;

import dados.Colecao.ColecaoEvents;
import dados.events.*;

public class EventsUi extends JPanel {
    private JButton refresh;
    private ColecaoEvents eventos;

    public EventsUi(ColecaoEvents eventos) {
        this.eventos = eventos;
        add(new AdicionarEventos(eventos));
    }
}
