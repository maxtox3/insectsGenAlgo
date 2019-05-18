package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Population {

    //мошки
    private List<Insect> insects;
    //размерность списка мошек
    private int size;
    //срок жизни мошки
    private int lifeSpan;

    //брачный бассейн хехе
    private List<Insect> matingPool;

    public Population(int size, int lifeSpan) {
        insects = new ArrayList<>();
        this.size = size;
        this.lifeSpan = lifeSpan;
        matingPool = new ArrayList<>();
        init();
    }

    public Population(int size, int lifeSpan, List<Insect> insects) {
        this.insects = insects;
        this.size = size;
        this.lifeSpan = lifeSpan;
        matingPool = new ArrayList<>();
    }

    private void init() {
        for (int i = 0; i < size; i++) {
            insects.add(new Insect(lifeSpan));
        }
    }

    public List<Insect> getInsects() {
        return insects;
    }

    public void evaluate(Target target) {

        double maxFit = 0;
        matingPool = new ArrayList<>();

        //рассчитываем и нормализовываем фитнесс
        for (Insect insect : insects) {
            insect.calculateFitness(target);
            if (insect.getFintess() > maxFit) {
                maxFit = insect.getFintess();
            }
        }

        for (Insect insect : insects) {
            insect.setFintess(insect.getFintess() / maxFit);
        }

        for (Insect insect : insects) {
            insect.setFintess(insect.getFintess() * 100);

            //ceil - наименьшее к ближ целому
            for (int j = 0; j < Math.ceil(insect.getFintess()); j++) {
                matingPool.add(insect);
            }
        }
    }

    //отбираем
    public List<Insect> selection() {
        Insect[] newInsects = new Insect[insects.size()];


        for (int i = 0; i < insects.size(); i++) {
            double r = Math.random() * matingPool.size();
            DNA parentA = matingPool.get((int) r).getDna();
            r = Math.random() * matingPool.size();
            DNA parentB = matingPool.get((int) r).getDna();
            DNA child = null;
            if (parentB != null) {
                if (parentA != null) {
                    child = parentA.crossOver(parentB);
                }
            }
            newInsects[i] = new Insect(lifeSpan, true);
            newInsects[i].setDna(child);
        }


        return Arrays.asList(newInsects);

    }
}
