package Repository;

import Domain.IEntity;
import Domain.IEntityFactory;

import java.io.*;
import java.util.Scanner;

public class TextRepository<T extends IEntity> extends MemoryRepository<T> {

    private String fileName;
    private IEntityFactory<T> entityFactory;

    public TextRepository(String fileName, IEntityFactory<T> entityFactory) throws FileNotFoundException {
        this.fileName = fileName;
        this.entityFactory = entityFactory;
        loadFile();
    }

    private void loadFile() {
        File file = new File(fileName);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                T entity = entityFactory.StringToEntity(line);
                add(entity); // Assuming this method correctly adds entities to entityList
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error loading file: " + e.getMessage());
            e.printStackTrace(); // This will print the stack trace for further debugging
        }
    }

    private void saveFile(){
        try (BufferedWriter output = new BufferedWriter(new FileWriter(fileName))) {
            for(T entity : entityList){
                output.write(entityFactory.entityToString(entity)+'\n');
            }
        } catch (FileNotFoundException fileNotFoundException) {
            try {
                new File(fileName).createNewFile();
            }catch (IOException ioException){

            }

        }catch (IOException ioException){

        }
    }

    @Override
    public void add(T entity) {
        super.add(entity);
        saveFile();
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
        saveFile();
    }

    @Override
    public void update(Integer id, T entity) {
        super.update(id, entity);
        saveFile();
    }
}
