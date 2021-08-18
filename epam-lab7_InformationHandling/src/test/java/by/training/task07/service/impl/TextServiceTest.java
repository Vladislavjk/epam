package by.training.task07.service.impl;

import by.training.task07.bean.TextComponent;
import by.training.task07.dao.DaoException;
import by.training.task07.service.ServiceException;
import by.training.task07.service.TextService;
import by.training.task07.service.factory.TextFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TextServiceTest {
    public static final String FILE_PATH_1 = "src/test/resourses/bin_input.txt";  // TODO ClassLoader get resourse
    public static final String FILE_PATH_2 = "src/test/resourses/input.txt";
    private static TextFactory textFactory;
    private static TextComponent textComponent1;
    private static TextComponent textComponent2;
    private static TextService textService;

    @BeforeClass
    public static void initialize() throws DaoException, ServiceException {
        textFactory = TextFactory.getInstance();
        textComponent1 = textFactory.createComposite(FILE_PATH_1);
        textComponent2 = textFactory.createComposite(FILE_PATH_2);
        textService = new TextServiceImpl();
    }

    @Test
    public void sortParagraphsBySentenceCountTest1() {
        String actual = "It is a (7^5|1&2<<(2|5>>2&71))|1200 established fact that a reader will be of a pagewhen looking at its" +
                " layout   Bye   It has survived - not only (five) centuries , but also the leap into 13<<2 " +
                "electronictypesetting , remaining 3>>5 essentially ~6&9|(3&4) unchanged  It was popularised in the5|(1&2&(3|" +
                "(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1) with the release of Letraset sheets containingLorem Ipsum passages , " +
                "and more recently with desktop publishing software like AldusPageMaker including versions of Lorem Ipsum   " +
                "It is a long established fact that a reader will be distracted by the readable content ofa page when looking " +
                "at its layout  The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78Ipsum is that it has a s normal " +
                "distribution of letters , as opposed to using (Contenthere) , content here' , making it look like readable " +
                "English   ";
        String expected = textService.sortParagraphsBySentenceCount(textComponent1).toString();
        assertEquals(actual, expected);
    }

    @Test
    public void sortParagraphsBySentenceCountTest2() {
        String actual = "We start by exploring Bayesian regression in a more general setup that enablesus to easily move from " +
                "a toy regression model to a more complex n regression model , such as Gaussian process regression  By " +
                "introducingBayesian regression in more depth , we show how it extends many of the conceptsin the previous " +
                "chapter  We develop kernel based machine learning methods(specifically Gaussian process regression) , and " +
                "demonstrate their application ” models of derivative prices   In general , it is difficult to develop intuition" +
                " about how the distribution of weights ina parametric regression model represents the data  Rather than induce" +
                " distributionsover variables , as we have seen in the previous chapter , we could instead inducedistributions" +
                " over functions  Specifically , we can express those intuitions using e kernel  ”   ";
        String expected = textService.sortParagraphsBySentenceCount(textComponent2).toString();
        assertEquals(actual, expected);
    }

    @Test
    public void sortWordsByLengthTest1() {
        String actual = "- , , It has not but the also leap only into 3>>5 13<<2 (five) survived remaining unchanged " +
                "centuries ~6&9|(3&4) essentially electronictypesetting  , It in of of was and the with more with like Ipsum " +
                "Lorem Ipsum sheets release desktop passages Letraset software recently versions including publishing " +
                "popularised AldusPageMaker containingLorem the5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1)   a a at It is be " +
                "by ofa the its fact that page long will when reader layout content looking readable distracted established  " +
                "a s , , , as of is it of to it has The that look like point using using here' normal making letters opposed " +
                "content English readable distribution (Contenthere) (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78Ipsum   a a a at It " +
                "is be of its fact that will reader layout looking pagewhen established (7^5|1&2<<(2|5>>2&71))|1200   Bye   ";
        String expected = textService.sortWordsByLength(textComponent1).toString();
        assertEquals(actual, expected);
    }

    @Test
    public void sortWordsByLengthTest2() {
        String actual = ", In it is to of ina how the the data about model general develop weights difficult intuition " +
                "parametric regression represents distribution  , , as we in we the than have seen over could Rather induce " +
                "chapter instead previous variables functions distributionsover inducedistributions  , e we can those using " +
                "kernel express intuitions Specifically  ”   a a a n , as We by in to to toy that more move from more such " +
                "start setup model model easily general complex process Bayesian Gaussian enablesus exploring regression " +
                "regression regression regression  , By in we it of how the the many more show depth chapter extends previous " +
                "regression conceptsin introducingBayesian  , ” We of and based their kernel models prices machine develop " +
                "process Gaussian learning derivative application demonstrate regression) methods(specifically   ";
        String expected = textService.sortWordsByLength(textComponent2).toString();
        assertEquals(actual, expected);
    }

    @Test
    public void sortTokensByFrequencyTest1() {
        String actual = "has also leap remaining essentially unchanged It survived - not only (five) centuries , but the " +
                "into 13<<2 electronictypesetting , 3>>5 ~6&9|(3&4)  passages AldusPageMaker was popularised release " +
                "Letraset containingLorem and software It in the5|(1&2&(3|(4&(1^5|6&47)|3)|(~89&4|(42&7)))|1) with the of " +
                "sheets Ipsum , more recently with desktop publishing like including versions of Lorem Ipsum   readable a " +
                "established fact that a reader distracted ofa page at layout It is long will be by the content when looking " +
                "its  readable that has a normal as making The point of using (~71&(2&3|(3|(2&1>>2|2)&2)|10&2))|78Ipsum " +
                "is it s distribution of letters , opposed to using (Contenthere) , content here' , it look like English   " +
                "a established fact that a reader a pagewhen at layout It is (7^5|1&2<<(2|5>>2&71))|1200 will be of looking " +
                "its   Bye   ";
        String expected = textService.sortTokensByFrequency(textComponent1, 'a').toString();
        assertEquals(actual, expected);
    }

    @Test
    public void sortTokensByFrequencyTest2() {
        String actual = "parametric data general about ina In , it is difficult to develop intuition how the distribution " +
                "of weights regression model represents the  variables Rather than as have chapter instead induce " +
                "distributionsover , we seen in the previous , we could inducedistributions over functions  Specifically " +
                "can , we express those intuitions using e kernel  ”   Bayesian Gaussian start a general that enablesus " +
                "easily a a as We by exploring regression in more setup to move from toy regression model to more complex " +
                "n regression model , such process regression  introducingBayesian many chapter By regression in more depth " +
                ", we show how it extends of the conceptsin the previous  Gaussian application based machine learning methods" +
                "(specifically and demonstrate derivative We develop kernel process regression) , their ” models of prices   ";
        String expected = textService.sortTokensByFrequency(textComponent2, 'a').toString();
        assertEquals(actual, expected);
    }

    @AfterClass
    public static void clear() {
        textFactory = null;
        textComponent1 = null;
        textComponent2 = null;
        textService = null;
    }
}
