package fr.gigaillards;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public final class Main {
    private Main() {
    }

    public static void main(String[] args) {
        Quarkus.run(args);
    }

    public static class CityAPI implements QuarkusApplication {

        @Override
        public int run(String... args) throws Exception {
            Quarkus.waitForExit();
            return 0;
        }
    }

}
