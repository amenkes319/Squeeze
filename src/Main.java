import java.util.Scanner;
import java.io.*;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			String output = "";
			Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + "\\src\\code sample.txt"));
			while(scanner.hasNextLine())
			{
				String line = scanner.nextLine();
				output += getSpaces(line) + "  " + getTrimmedLine(line) + "\n";
			}
			outputTrimmed(output);
			scanner.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private static int getSpaces(String line)
	{
		int spaces = 0;

		for(int i=0; i<line.length(); i++)
		{
			if(line.charAt(i) == '	')
				spaces += 3;
		}

		return spaces;
	}

	private static String getTrimmedLine(String line)
	{
		String trimmedLine = line.substring(getSpaces(line)/3);

		return trimmedLine;
	}

	private static void outputTrimmed(String output)
	{
	    try
	    {
	    	BufferedWriter writer = new BufferedWriter(new FileWriter("src\\output.txt"));
			writer.write(output);
		    writer.close();
		}
	    catch (IOException e)
	    {
			e.printStackTrace();
		}
	}
}