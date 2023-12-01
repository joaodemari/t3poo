package dados;

import dados.Atendimento.Atendimento;
import dados.Atendimento.Status;
import dados.Colecao.ColecaoAtendimento;
import dados.Colecao.ColecaoEquipe;

public class AlocarAtendimentos {
    public void alocarAtendimentos(ColecaoAtendimento atendimentos, ColecaoEquipe equipes) {
        for (Atendimento atendimento : atendimentos) {
            if (atendimento.getStatus() == Status.PENDENTE) {
                Equipe equipeDisponivel = encontrarEquipeDisponivel(atendimento, equipes);

                if (equipeDisponivel != null) {
                    atendimento.setStatus(Status.EXECUTANDO);
                    equipeDisponivel.addAtendimento(atendimento);
                } else {
                    atendimento.setStatus(Status.CANCELADO);
                }
            }
        }
    }

    private Equipe encontrarEquipeDisponivel(Atendimento atendimento, ColecaoEquipe equipes) {
        for (Equipe equipe : equipes) {
            if (equipe.estaDisponivel() && isWithinDistance(equipe, atendimento)) {
                return equipe;
            }
        }
        return null;
    }

    private boolean isWithinDistance(Equipe equipe, Atendimento atendimento) {
        return true;
    }

    private boolean equipeDisponivel(Equipe equipe, Atendimento atendimento) {
        return equipe.getStatus() == Status.DISPONIVEL;
    }
}
