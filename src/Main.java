
import java.io.*;

/**
 * В классе Main, в соответствии с заданием ментора №2,
 * описан алгоритм чтения и сравнеия двух txt файлов
 * и вывода отличающейся строки из второго файла в CSV файл
 * @author Tsibenkov Artyem
 * @version 1.0
 */
    public class Main
    {
        public static void main(String[] args) throws IOException
        {
            /** Создание двух объектов для построчного считывания сравниваемых файлов
             * с указанием пути к этим файлам */
            BufferedReader reader1 = new BufferedReader(new FileReader("src/1.txt"));

            BufferedReader reader2 = new BufferedReader(new FileReader("src/2.txt"));

            /** считывание строк в переменные типа String */
            String line1 = reader1.readLine();

            String line2 = reader2.readLine();

            /** проверка, если csv файл с отличиями был создан ранее, то удалить его */
            File f = new File("compare.csv");
            if (f.exists())
                f.delete();

            /** создание объекта для записи различий в файл и сам файл */
            PrintWriter pw = new PrintWriter(new File("compare.csv"));

            /** создание объекта типа StringBuilder, в который будут записаны различающиеся строки и разделители */
            StringBuilder sb = new StringBuilder();

            /** флаг compar будет показывать false если файлы имеют различия */
            boolean compar = true;

            /** цикл сравнеия работает пока в первом файле не кончатся строки */
            while (line1 != null || line2 != null) {

                /** если одна строка не равна другой (без учета регистра) то происходит запись в csv файл строки
                 * второго файла и разделителя*/
                if(! line1.equalsIgnoreCase(line2)) {

                    sb.append(line2);
                    sb.append(";");
                    compar = false;
                }

                /** считывание следующих строк */
                line1 = reader1.readLine();

                line2 = reader2.readLine();
            }

            /** вывод результата в консоль */
            if(compar) {

                System.out.println("Сверяемые файлы одинаковые");
            }
            else {

                System.out.println("Файлы имеют различе. Смотри compare.csv");
             }

            pw.write(sb.toString());

            pw.close();

            reader1.close();

            reader2.close();
        }
    }

