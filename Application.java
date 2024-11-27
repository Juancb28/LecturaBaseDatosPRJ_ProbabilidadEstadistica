package file_reader;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Application {

    public static void main(String[] args) throws IOException {

        ArrayList<String> DDBB = new ArrayList<>(Arrays.asList(
                "BigQuery", "Cassandra", "Clickhouse", "Cloud Firestore", "Cockroachdb", "Cosmos DB", "Couch DB",
                "Couchbase", "Databricks SQL", "Datomic", "DuckDB", "Dynamodb", "Elasticsearch", "EventStoreDB",
                "Firebase Realtime Database", "Firebird", "H2", "IBM DB2", "InfluxDB", "MariaDB", "Microsoft Access",
                "Microsoft SQL Server", "MongoDB", "MySQL", "Neo4J", "Oracle", "PostgreSQL", "Presto", "RavenDB",
                "Redis", "Snowflake", "Solr", "SQLite", "Supabase", "TiDB"
        ));

        ArrayList<String> orgSize = new ArrayList<>(Arrays.asList(
                "Just me - I am a freelancer, sole proprietor, etc.", "2 to 9 employees", "10 to 19 employees",
                "20 to 99 employees", "100 to 499 employees", "500 to 999 employees", "1,000 to 4,999 employees",
                "5,000 to 9,999 employees", "10,000 or more employees", "I don’t know"
        ));

        ArrayList<String> age = new ArrayList<>(Arrays.asList(
                "Under 18 years old", "18-24 years old", "25-34 years old", "35-44 years old", "45-54 years old",
                "55-64 years old", "65 years or older", "Prefer not to say"
        ));

        ArrayList<String> mainBranch = new ArrayList<>(Arrays.asList(
                "I am a developer by profession", "I am not primarily a developer, but I write code sometimes as part of my work/studies",
                "I used to be a developer by profession, but no longer am", "I am learning to code",
                "I code primarily as a hobby", "None of these"
        ));

        ArrayList<String> IDE = new ArrayList<>(Arrays.asList(
                "Android Studio", "BBEdit", "CLion", "Code::Blocks", "DataGrip", "Eclipse", "Emacs", "Fleet", "Geany",
                "Goland", "Helix", "IntelliJ IDEA", "IPython", "Jupyter Notebook/JupyterLab", "Kate", "Nano", "Neovim",
                "Netbeans", "Notepad++", "PhpStorm", "PyCharm", "Qt Creator", "Rad Studio (Delphi, C++ Builder)",
                "Rider", "RStudio", "RubyMine", "Spacemacs", "Spyder", "Sublime Text", "Vim", "Visual Studio",
                "Visual Studio Code", "VSCodium", "WebStorm", "Xcode"
        ));

        ArrayList<String> educationLevel = new ArrayList<>(Arrays.asList(
                "Primary/elementary school",
                "Secondary school (e.g. American high school, German Realschule or Gymnasium, etc.)",
                "Some college/university study without earning a degree",
                "Associate degree (A.A., A.S., etc.)",
                "Bachelor’s degree (B.A., B.S., B.Eng., etc.)",
                "Master’s degree (M.A., M.S., M.Eng., MBA, etc.)",
                "Professional degree (JD, MD, Ph.D, Ed.D, etc.)",
                "Something else"
        ));

        ArrayList<String> workSituation = new ArrayList<>(Arrays.asList(
                "Remote",
                "In-person",
                "Hybrid (some remote, some in-person)"
        ));

        ArrayList<String> learningMethods = new ArrayList<>(Arrays.asList(
                "Books / Physical media",
                "Coding Bootcamp",
                "Colleague",
                "Friend or family member",
                "Online Courses or Certification",
                "On the job training",
                "Other online resources (e.g., videos, blogs, forum, online community)",
                "School (i.e., University, College, etc)"
        ));

        ArrayList<String> onlineResources = new ArrayList<>(Arrays.asList(
                "Stack Overflow", "Blogs", "Online community (including social media)", "Video-based online courses",
                "Online challenges (e.g., daily or weekly coding challenges)", "Coding sessions (live or recorded)",
                "Written-based online courses", "How-to videos", "Auditory material (e.g., podcasts)",
                "Technical documentation", "Certification videos", "Books", "Games that teach programming",
                "AI chatbot or other tool", "Written tutorials", "Interactive tutorial"
        ));

        ArrayList<String> programmingLanguages = new ArrayList<>(Arrays.asList(
                "Ada", "Apex", "Assembly", "Bash/Shell (all shells)", "C", "C#", "C++", "Clojure", "Cobol", "Crystal",
                "Dart", "Delphi", "Elixir", "Erlang", "F#", "Fortran", "GDScript", "Go", "Groovy", "Haskell", "HTML/CSS",
                "Java", "JavaScript", "Julia", "Kotlin", "Lisp", "Lua", "MATLAB", "MicroPython", "Nim", "Objective-C",
                "OCaml", "Perl", "PHP", "PowerShell", "Prolog", "Python", "R", "Ruby", "Rust", "Scala", "Solidity",
                "SQL", "Swift", "TypeScript", "VBA", "Visual Basic (.Net)", "Zephyr", "Zig"
        ));


        // Crear mapas para contar ocurrencias de cada elemento
        HashMap<String, Integer> dbCount = initializeCounterMap(DDBB);
        HashMap<String, Integer> orgSizeCount = initializeCounterMap(orgSize);
        HashMap<String, Integer> ageCount = initializeCounterMap(age);
        HashMap<String, Integer> mainBranchCount = initializeCounterMap(mainBranch);
        HashMap<String, Integer> ideCount = initializeCounterMap(IDE);
        HashMap<String, Integer> eduLevel = initializeCounterMap(educationLevel);
        HashMap<String, Integer> wkSituation = initializeCounterMap(workSituation);
        HashMap<String, Integer> leMethods = initializeCounterMap(learningMethods);
        HashMap<String, Integer> onResources = initializeCounterMap(onlineResources);
        HashMap<String, Integer> progLangua = initializeCounterMap(programmingLanguages);

        // Mapa para contar rangos de experiencia
        HashMap<String, Integer> experienceCount = initializeExperienceMap();

        String[] aux2;
        String aux;

        int cont = 0;

        File result = new File("src/file_reader/result.csv");
        FileReader reader = new FileReader(result);
        BufferedReader bf = new BufferedReader(reader);

        while ((aux = bf.readLine()) != null) {
            aux2 = aux.split(";");
            if (aux2.length > 221 && aux2.length < 250) {

                countOccurrence(DDBB, dbCount, aux2);
                countOccurrence(orgSize, orgSizeCount, aux2);
                countOccurrence(age, ageCount, aux2);
                countOccurrence(mainBranch, mainBranchCount, aux2);
                countOccurrence(IDE, ideCount, aux2);
                countOccurrence(educationLevel, eduLevel, aux2);
                countOccurrence(workSituation, wkSituation, aux2);
                countOccurrence(learningMethods, leMethods, aux2);
                countOccurrence(onlineResources, onResources, aux2);
                countOccurrence(programmingLanguages, progLangua, aux2);

                // Contar experiencia en rangos
                int experienceYears = Integer.parseInt(aux2[18]);
                countExperienceRange(experienceCount, experienceYears);

                cont++;
            }
        }

        // Cerrar el lector
        bf.close();

        // Imprimir resultados
        System.out.println("Database Counts:");
        printCountMap(dbCount);
        System.out.println("\nOrganization Size Counts:");
        printCountMap(orgSizeCount);
        System.out.println("\nAge Counts:");
        printCountMap(ageCount);
        System.out.println("\nMain Branch Counts:");
        printCountMap(mainBranchCount);
        System.out.println("\nIDE Counts:");
        printCountMap(ideCount);
        System.out.println("\nExperience Counts:");
        printCountMap(experienceCount);
        System.out.println("\nEducation level:");
        printCountMap(eduLevel);
        System.out.println("\nWork situation:");
        printCountMap(wkSituation);
        System.out.println("\nLearnings methods:");
        printCountMap(leMethods);
        System.out.println("\nOnline Resources:");
        printCountMap(onResources);
        System.out.println("\nProgramming languages:");
        printCountMap(progLangua);

        System.out.println("\nSe ha leido " + cont + " datos.");
    }

    // Inicializa el HashMap con cada elemento de la lista con un contador en 0
    private static HashMap<String, Integer> initializeCounterMap(ArrayList<String> list) {
        HashMap<String, Integer> counterMap = new HashMap<>();
        for (String item : list) {
            counterMap.put(item, 0);
        }
        return counterMap;
    }

    // Inicializa el HashMap para rangos de experiencia
    private static HashMap<String, Integer> initializeExperienceMap() {
        HashMap<String, Integer> experienceMap = new HashMap<>();
        experienceMap.put("0-5 years", 0);
        experienceMap.put("6-10 years", 0);
        experienceMap.put("11-15 years", 0);
        experienceMap.put("16-20 years", 0);
        experienceMap.put("21-25 years", 0);
        experienceMap.put("26-30 years", 0);
        experienceMap.put("31-35 years", 0);
        experienceMap.put("36-40 years", 0);
        experienceMap.put("41-45 years", 0);
        experienceMap.put("46-50 years", 0);
        return experienceMap;
    }

    // Función para contar la ocurrencia de cada elemento en la lista y actualizar el mapa de contadores
    private static void countOccurrence(ArrayList<String> list, HashMap<String, Integer> counterMap, String[] aux) {
        for (String item : list) {
            for (String element : aux) {
                if (item.equalsIgnoreCase(element)) {
                    counterMap.put(item, counterMap.get(item) + 1);
                }
            }
        }
    }

    // Función para contar el rango de experiencia
    private static void countExperienceRange(HashMap<String, Integer> experienceMap, int experienceYears) {
        if (experienceYears >= 0 && experienceYears <= 5) {
            experienceMap.put("0-5 years", experienceMap.get("0-5 years") + 1);
        } else if (experienceYears <= 10) {
            experienceMap.put("6-10 years", experienceMap.get("6-10 years") + 1);
        } else if (experienceYears <= 15) {
            experienceMap.put("11-15 years", experienceMap.get("11-15 years") + 1);
        } else if (experienceYears <= 20) {
            experienceMap.put("16-20 years", experienceMap.get("16-20 years") + 1);
        } else if (experienceYears <= 25) {
            experienceMap.put("21-25 years", experienceMap.get("21-25 years") + 1);
        } else if (experienceYears <= 30) {
            experienceMap.put("26-30 years", experienceMap.get("26-30 years") + 1);
        } else if (experienceYears <= 35) {
            experienceMap.put("31-35 years", experienceMap.get("31-35 years") + 1);
        } else if (experienceYears <= 40) {
            experienceMap.put("36-40 years", experienceMap.get("36-40 years") + 1);
        } else if (experienceYears <= 45) {
            experienceMap.put("41-45 years", experienceMap.get("41-45 years") + 1);
        } else if (experienceYears <= 50) {
            experienceMap.put("46-50 years", experienceMap.get("46-50 years") + 1);
        }
    }

    // Imprime el mapa de contadores
    private static void printCountMap(HashMap<String, Integer> countMap) {
        for (String key : countMap.keySet()) {
            System.out.println(key + ": " + countMap.get(key));
        }
    }
}