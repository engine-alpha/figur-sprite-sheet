import ea.Figur
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    if (args.size != 2) {
        println("Usage: java -jar /path/to/figur-sprite-sheet.jar /path/to/input.eaf /path/to/output.png")
        System.exit(1)
    }

    val inputPath = args[0]
    val outputPath = args[1]

    if (!File(inputPath).exists()) {
        println("The specified input path '$inputPath' doesn't exist.")
        System.exit(2)
    }

    if (File(outputPath).exists()) {
        println("The specified output path '$outputPath' already exists.")

        confirmation@ while (true) {
            println("Do you want to continue? [y/n]: ")

            when (readLine()) {
                null -> {
                    println("No confirmation, aborting.")
                    System.exit(2)
                }

                "y", "Y" -> {
                    break@confirmation
                }

                "n", "N" -> {
                    println("Ok, aborting.")
                    System.exit(0)
                }

                else -> {
                    continue@confirmation
                }
            }
        }
    }

    val figur = Figur(inputPath)
    val animation = figur.animation()

    figur.faktorSetzen(1)

    val result = BufferedImage(animation[0].breiteN() * animation.size, animation[0].hoeheN(), BufferedImage.TYPE_INT_ARGB)
    val graphics = result.createGraphics()

    for (image in animation) {
        image.zeichnen(graphics, 0, 0, false, false)
        graphics.translate(animation[0].breiteN(), 0)
    }

    ImageIO.write(result, "png", File(outputPath))

    System.exit(0)
}