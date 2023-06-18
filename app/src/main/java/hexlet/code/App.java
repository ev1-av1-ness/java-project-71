package hexlet.code;

import picocli.CommandLine;
import java.util.concurrent.Callable;

import static java.lang.System.out;
import static java.lang.System.err;

@CommandLine.Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class App implements Callable<Integer> {

    private static final int SUCCESS_EXIT_CODE = 0;
    private static final int ERROR_EXIT_CODE = 1;

    @CommandLine.Option(names = {"-f", "--format"}, defaultValue = "stylish", description = "output format [default: stylish]")
    private String format;

    @CommandLine.Parameters(paramLabel = "filepath1",
            index = "0",
            description = "path to first file")
    private String filePath1;

    @CommandLine.Parameters(paramLabel = "filepath2",
            index = "1",
            description = "path to second file")
    private String filePath2;

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     */
    @Override
    public Integer call() {
        try {
            //
        } catch (Exception e) {
            err.println(e.getMessage());
            return ERROR_EXIT_CODE;
        }
        return SUCCESS_EXIT_CODE;
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}