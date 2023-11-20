package controller.entities.planets;

import controller.enums.PlanetIndex;

public class RubyOnRails extends Planet {

    private static final String DESCRIPTION = "Ruby on Rails, carinhosamente conhecido como Rails, é um framework de desenvolvimento web que opera no Planeta Ruby. Sua ênfase na convenção sobre configuração acelera o desenvolvimento, tornando-o uma escolha popular para construir aplicativos web robustos e escaláveis.";

    public RubyOnRails() {
        super("Ruby On Rails", "ruby", DESCRIPTION, PlanetIndex.RUBY_ON_RAILS, 2, 48.0, "ruby.png");
    }
}
