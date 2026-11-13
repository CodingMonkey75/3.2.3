import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListMethods
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        ArrayList<String> animalList = new ArrayList<String>();
        animalList.add("Dog");
        animalList.add("Cat");
        animalList.add("Rabbit");

        String command = "";

        while (!command.equals("q"))
        {
            // Display the list
            System.out.println(animalList);

            // Prompt for a command
            System.out.println("Would you like to (a)dd, (i)nsert, (r)emove, Re(p)lace or (q)uit?");
            command = input.nextLine().trim().toLowerCase();

            if (command.equals("a"))
            {
                System.out.println("Enter an animal:");
                String animal = input.nextLine();
                animalList.add(animal);
            }
            else if (command.equals("i"))
            {
                System.out.println("Enter an animal:");
                String animal = input.nextLine();
                System.out.println("Enter a position:");
                int position = readPosition(input);

                // Valid insert positions are 1 through size + 1 (size + 1 = the end)
                if (position >= 1 && position <= animalList.size() + 1)
                {
                    animalList.add(position - 1, animal);
                }
                else
                {
                    System.out.println("Bad position!");
                }
            }
            else if (command.equals("r"))
            {
                System.out.println("Enter a position:");
                int position = readPosition(input);

                if (position >= 1 && position <= animalList.size())
                {
                    animalList.remove(position - 1);
                }
                else
                {
                    System.out.println("Bad position!");
                }
            }
            else if (command.equals("p"))
            {
                System.out.println("Enter an animal:");
                String animal = input.nextLine();
                System.out.println("Enter a position:");
                int position = readPosition(input);

                if (position >= 1 && position <= animalList.size())
                {
                    animalList.set(position - 1, animal);
                }
                else
                {
                    System.out.println("Bad position!");
                }
            }
            else if (!command.equals("q"))
            {
                System.out.println("Invalid command!");
            }
        }

        input.close();
    }

    /** Reads a line and converts it to an int. Returns -1 if it isn't a number. */
    private static int readPosition(Scanner input)
    {
        try
        {
            return Integer.parseInt(input.nextLine().trim());
        }
        catch (NumberFormatException e)
        {
            return -1;
        }
    }
}