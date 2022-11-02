package com.example.workloadmanager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WorkloadManagerApplicationTests {

    @Test
    void contextLoads() {
        List<String> names = List.of("Olivia",
            "Amelia",
            "Isla",
            "Ava",
            "Mia",
            "Isabella",
            "Grace",
            "Sophia",
            "Lily",
            "Emily",
            "Freya",
            "Ivy",
            "Ella",
            "Charlotte",
            "Florence",
            "Evie",
            "Rosie",
            "Willow",
            "Phoebe",
            "Sophie",
            "Evelyn",
            "Sienna",
            "Elsie",
            "Sofia",
            "Alice",
            "Ruby",
            "Matilda",
            "Isabelle",
            "Harper",
            "Daisy",
            "Emilia",
            "Jessica",
            "Maya",
            "Eva",
            "Luna",
            "Eliza",
            "Millie",
            "Chloe",
            "Penelope",
            "Maisie",
            "Esme",
            "Aria",
            "Scarlett",
            "Imogen",
            "Thea",
            "Harriet",
            "Ada",
            "Layla",
            "Mila",
            "Eleanor",
            "Violet",
            "Elizabeth",
            "Bella",
            "Rose",
            "Emma",
            "Erin",
            "Molly",
            "Lola",
            "Lucy",
            "Hallie",
            "Bonnie",
            "Ellie",
            "Zara",
            "Maria",
            "Robyn",
            "Hannah",
            "Nancy",
            "Gracie",
            "Darcie",
            "Iris",
            "Amber",
            "Amelie",
            "Anna",
            "Maryam",
            "Albert",
            "Hunter",
            "Dylan",
            "David",
            "Jude",
            "Frankie",
            "Ezra",
            "Roman",
            "Toby",
            "Riley",
            "Ronnie",
            "Frederick",
            "Carter",
            "Stanley",
            "Gabriel",
            "Bobby",
            "Jesse",
            "Michael",
            "Mohammad",
            "Grayson",
            "Elliot",
            "Liam",
            "Jenson",
            "Harvey",
            "Ralph",
            "Jayden",
            "Jake",
            "Harley",
            "Ellis",
            "Charles",
            "Elliott",
            "Jasper",
            "Felix",
            "Finn",
            "Rowan",
            "Caleb",
            "Leon",
            "Chester",
            "Ibrahim",
            "Ollie",
            "Jackson",
            "Alfred",
            "Ryan",
            "Matthew",
            "Rupert",
            "Luke"
        );
        StringBuilder builder = new StringBuilder();
        names.forEach(name -> builder.append("insert into t_users(id, name) values (")
            .append(names.indexOf(name))
            .append(",")
            .append("'")
            .append(name)
            .append("'")
            .append(");"));
        System.out.println(builder);
    }

}
