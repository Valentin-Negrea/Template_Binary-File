import Domain.*;
import Repository.*;
import Service.ServiceEntity1;
import Service.ServiceEntity2;
import User_Interface.ConsoleInterface;

import java.io.FileReader;

public class Main {

    public static void main(String[] args) throws Exception {


        java.util.Properties p = new java.util.Properties();

        p.load(new FileReader("config.properties"));

        String repo = p.getProperty("Repository");
        String entity1 = p.getProperty("Entity1");
        String entity2 = p.getProperty("Entity2");


        AbstractRepository<Entity1> repository1 = null;
        AbstractRepository<Entity2> repository2 = null;

        switch (repo){
            case "binary":
                repository1 = new BinaryRepository<>(entity1);
                repository2 = new BinaryRepository<>(entity2);

                ServiceEntity1 service1 =new ServiceEntity1(repository1);
                ServiceEntity2 service2 = new ServiceEntity2(repository2);

                ConsoleInterface consoleInterface=new ConsoleInterface(service1, service2);
                consoleInterface.run();
                break;
            case "text":
                TextRepository<Entity1> repositoryText1 = new TextRepository<>("ceva1.txt", new Entity1Factory());
                TextRepository<Entity2> repositoryText2 = new TextRepository<>("ceva2.txt", new Entity2Factory());
                ServiceEntity1 service3 =new ServiceEntity1(repositoryText1);
                ServiceEntity2 service4 = new ServiceEntity2(repositoryText2);

                ConsoleInterface consoleInterface2=new ConsoleInterface(service3, service4);
                consoleInterface2.run();

                break;
            case "memory":
                MemoryRepository<Entity1> repositoryMemory1 = new MemoryRepository<Entity1>();
                MemoryRepository<Entity2> repositoryMemory2 = new MemoryRepository<Entity2>();

                ServiceEntity1 service5 = new ServiceEntity1(repositoryMemory1);
                ServiceEntity2 service6 = new ServiceEntity2(repositoryMemory2);

                ConsoleInterface consoleInterface3=new ConsoleInterface(service5, service6);
                consoleInterface3.run();
                break;

        }



    }
}