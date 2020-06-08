package tacos;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import tacos.dto.Ingredient;
import tacos.dto.Ingredient.Type;
import tacos.data.IngredientRepository;
import tacos.data.UserRepository;
import tacos.dto.User;

//@Profile("prod")
@Configuration
public class DevelopmentConfig {

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository repo,
                                        UserRepository userRepo, PasswordEncoder encoder) { // user repo for ease of testing with a built-in user
        return args -> {
            repo.save(new Ingredient(1L, "Flour Tortilla", Type.WRAP));
            repo.save(new Ingredient(2L, "Corn Tortilla", Type.WRAP));
            repo.save(new Ingredient(3L, "Ground Beef", Type.PROTEIN));
            repo.save(new Ingredient(4L, "Carnitas", Type.PROTEIN));
            repo.save(new Ingredient(5L, "Diced Tomatoes", Type.VEGGIES));
            repo.save(new Ingredient(6L, "Lettuce", Type.VEGGIES));
            repo.save(new Ingredient(7L, "Cheddar", Type.CHEESE));
            repo.save(new Ingredient(8L, "Monterrey Jack", Type.CHEESE));
            repo.save(new Ingredient(9L, "Salsa", Type.SAUCE));
            repo.save(new Ingredient(10L, "Sour Cream", Type.SAUCE));


            userRepo.save(new User("habuma", encoder.encode("password"),
                    "Craig Walls", "123 North Street", "Cross Roads", "TX",
                    "76227", "123-123-1234"));
        };
    }

}
