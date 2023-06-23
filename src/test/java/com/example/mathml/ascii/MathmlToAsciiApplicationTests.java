package com.example.mathml.ascii;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MathmlToAsciiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	MathMLConverter mathMLConverter;

	@Autowired
	OperatorUtils operatorUtils;

	@Test
	public void testIsOpenOperator(){
		Boolean res = operatorUtils.isOpenOperator("d");
		assertFalse(res,"Expected the service method to return true");
	}

	@Test
	public void testIsCloseOperator(){
		Boolean res = operatorUtils.isCloseOperator("}");
		assertTrue(res,"Expected the service method to return true");
	}

	@Test
	public void testToAscii(){
		String mathml = "<math><mrow><mi>x</mi><mo>+</mo><mn>1</mn></mrow></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"( x + 1 )");
	}


	@Test
	public void testToAscii2(){
		String mathml = "<math><mn>1</mn><mo>+</mo><mn>2</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"1 + 2");
	}

	@Test
	public void testToAscii3(){
		String mathml = "<math><mn>1</mn><mo>-</mo><mn>2</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"1 - 2");
	}

	@Test
	public void testToAscii4(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mn>1</mn><mo>.</mo><mn>2</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"1 * 2");
	}

	@Test
	public void testToAscii5(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mn>1</mn><mo>&Star;</mo><mn>2</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"1 ** 2");
	}
	@Test
	public void testToAscii6(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mn>1</mn><mo>&times;</mo><mn>2</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"1 xx 2");
	}
	@Test
	public void testToAscii7(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mi>a</mi><mi>b</mi></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"a b");
	}
	@Test
	public void testToAscii8(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mn>2</mn><mi>b</mi></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"2 b");
	}
	@Test
	public void testToAscii9(){
		String mathml = "<math><mn>2</mn><mrow><mo>(</mo><mi>x</mi><mo>+</mo><mn>2</mn><mo>)</mo></mrow></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"2 ( x + 2 )");
	}
	@Test
	public void testToAscii10(){
		String mathml = "<math><mn>1</mn><mo>/</mo><mn>2</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"1 // 2");
	}
	@Test
	public void testToAscii11(){
		String mathml = "<math><mfrac><mn>1</mn><mn>2</mn></mfrac></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"1 / 2");
	}
	@Test
	public void testToAscii12(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mn>1</mn><mo>&divide;</mo><mn>2</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"1 -: 2");
	}
	@Test
	public void testToAscii13(){
		String mathml = "<math><mi>a</mi><mo>+</mo><mi>b</mi></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"a + b");
	}
	@Test
	public void testToAscii14(){
		String mathml = "<math><mn>1</mn><mo>+</mo><mi>b</mi></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"1 + b");
	}
	@Test
	public void testToAscii15(){
		String mathml = "<math><msup><mi>a</mi><mn>2</mn></msup></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"a ^ 2");
	}
	@Test
	public void testToAscii16(){
		String mathml = "<math><msup><mi>x</mi><mrow><mi>i</mi><mi>j</mi></mrow></msup></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"x ^ ( i j )");
	}
	@Test
	public void testToAscii17(){
		String mathml = "<math><msub><mi>x</mi><mn>1</mn></msub></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"x _ 1");
	}
	@Test
	public void testToAscii18(){
		String mathml = "<math><msub><mi>x</mi><mrow><mi>i</mi><mi>j</mi></mrow></msub></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"x _ ( i j )");
	}
	@Test
	public void testToAscii19(){
		String mathml = "<math><mi>a</mi><mo>+</mo><mn>3</mn><mo>=</mo><mn>4</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"a + 3 = 4");
	}
	@Test
	public void testToAscii20(){
		String mathml = "<math><mfrac><mrow><mn>1</mn><mo>+</mo><mn>2</mn><mo>+</mo><mn>3</mn><mo>+</mo><mn>4</mn></mrow><mn>10</mn></mfrac></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"( 1 + 2 + 3 + 4 ) / 10");
	}
	@Test
	public void testToAscii21(){
		String mathml = "<math><mrow><mo>(</mo><mi>x</mi><mo>+</mo><mn>1</mn><mo>)</mo></mrow></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"( x + 1 )");
	}
	@Test
	public void testToAscii22(){
		String mathml = "<math><mfrac><mrow><mi>x</mi><mo>+</mo><mn>1</mn></mrow><mn>4</mn></mfrac></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"( x + 1 ) / 4");
	}
	@Test
	public void testToAscii23(){
		String mathml = "<math><mfrac><mrow><mn>1</mn><mo>+</mo><mn>2</mn><mo>+</mo><mn>3</mn><mo>+</mo><mn>4</mn></mrow><mrow><mn>10</mn><mo>+</mo><mi>a</mi><mo>+</mo><mi>b</mi></mrow></mfrac></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"( 1 + 2 + 3 + 4 ) / ( 10 + a + b )");
	}
	@Test
	public void testToAscii24(){
		String mathml = "<math><mn>4</mn><mfrac><mn>2</mn><mn>3</mn></mfrac></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"4 2 / 3");
	}
	@Test
	public void testToAscii25(){
		String mathml = "<math><mfrac><mn>3</mn><mn>4</mn></mfrac><mrow><mo>(</mo><mn>240</mn><mo>)</mo></mrow><mo>=</mo><mn>180</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"3 / 4 ( 240 )  = 180");
	}
	@Test
	public void testToAscii26(){
		String mathml = "<math><mrow><mo>(</mo><mn>0.37</mn><mo>)</mo></mrow><mrow><mo>(</mo><mn>120</mn><mo>)</mo></mrow><mo>=</mo><mn>44.4</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"( 0.37 )  ( 120 )  = 44.4");
	}
	@Test
	public void testToAscii27(){
		String mathml = "<math><msqrt><mi>x</mi></msqrt></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"sqrt x");
	}
	@Test
	public void testToAscii28(){
		String mathml = "<math><msqrt><mrow><mi>x</mi></mrow></msqrt></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"sqrt ( x )");
	}
	@Test
	public void testToAscii29(){
		String mathml = "<math><msqrt><mrow><mi>x</mi><mo>+</mo><mn>2</mn></mrow></msqrt></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"sqrt ( x + 2 )");
	}
	@Test
	public void testToAscii30(){
		String mathml = "<math><mi>a</mi><mo>=</mo><mn>2</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"a = 2");
	}
	@Test
	public void testToAscii31(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mi>a</mi><mo>&ne;</mo><mn>2</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"a != 2");
	}
	@Test
	public void testToAscii32(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mi>a</mi><mo>&lt;</mo><mn>2</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"a < 2");
	}
	@Test
	public void testToAscii33(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mi>a</mi><mo>&gt;</mo><mn>2</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"a > 2");
	}
	@Test
	public void testToAscii34(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mi>a</mi><mo>&le;</mo><mi>b</mi></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"a <= b");
	}
	@Test
	public void testToAscii35(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mi>a</mi><mo>&ge;</mo><mi>b</mi></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"a >= b");
	}
	@Test
	public void testToAscii36(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mi>a</mi><mo>&asymp;</mo><mn>2</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"a ~~ 2");
	}
	@Test
	public void testToAscii37(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mrow><mo>[</mo><mn>1</mn><mo>,</mo><mn>3</mn><mo>]</mo></mrow></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"[ 1 , 3 ]");
	}
	@Test
	public void testToAscii38(){
		String mathml = "<math><mrow><mo>[</mo><mn>1</mn><mo>,</mo><mn>3</mn><mo>)</mo></mrow></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"[ 1 , 3 )");
	}
	@Test
	public void testToAscii39(){
		String mathml = "<math><mrow><mo>(</mo><mn>1</mn><mo>,</mo><mn>3</mn><mo>]</mo></mrow></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"( 1 , 3 ]");
	}
	@Test
	public void testToAscii40(){
		String mathml = "<math><mrow><mo>(</mo><mn>1</mn><mo>,</mo><mn>3</mn><mo>)</mo></mrow></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"( 1 , 3 )");
	}
	@Test
	public void testToAscii41(){
		String mathml = "<math><mrow><mo>{</mo><mn>1</mn><mo>,</mo><mn>3</mn><mo>}</mo></mrow></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"{ 1 , 3 }");
	}
	@Test
	public void testToAscii42(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mn>3.3</mn><mover><mn>3</mn><mo>&macr;</mo></mover></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"3.3 bar 3");
	}

	@Test
	public void testToAscii43(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mover><mrow><mi>a</mi><mi>b</mi></mrow><mo>&macr;</mo></mover></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"bar ( a b )");
	}

	@Test
	public void testToAscii44(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mover><mrow><mi>a</mi><mi>b</mi></mrow><mo>&rarr;</mo></mover></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"vec ( a b )");
	}

	@Test
	public void testToAscii45(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mover><mrow><mi>a</mi><mi>b</mi></mrow><mo>&harr;</mo></mover></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"line ( a b )");
	}

	@Test
	public void testToAscii46(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mover><mrow><mi>a</mi><mi>b</mi></mrow><mo>&#8978;</mo></mover></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"arc ( a b )");
	}

	@Test
	public void testToAscii47(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mn>2</mn><mo>&plusmn;</mo><mn>3</mn></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"2 +- 3");
	}

	@Test
	public void testToAscii48(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mn>2</mn><mo>+</mo><mtext>dog</mtext></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"2 + text(dog)");
	}

	@Test
	public void testToAscii49(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mn>2</mn><mo>+</mo><mtext>?</mtext></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"2 + text(?)");
	}

	@Test
	public void testToAscii50(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mn>2</mn><mo>+</mo><mo>?</mo></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"2 +  ?");
	}

	@Test
	public void testToAscii51(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mn>2</mn><mo>+</mo><mtext>__</mtext></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"2 + text(__)");
	}

	@Test
	public void testToAscii52(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mo>&ang;</mo></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"/_");
	}

	@Test
	public void testToAscii53(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mo>&ang;</mo><mi>A</mi><mi>B</mi><mi>C</mi></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"/_ A B C");
	}

	@Test
	public void testToAscii54(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mn>4</mn><mo>&deg;</mo></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"4 deg");
	}

	@Test
	public void testToAscii55(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mstyle><mn>1</mn><mo>+</mo><mn>2</mn></mstyle></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"1 + 2");
	}

	@Test
	public void testToAscii56(){
		String mathml = "<!DOCTYPE root PUBLIC \"-//W3C//DTD MathML 2.0//EN\" \"http://www.w3.org/Math/DTD/mathml2/mathml2.dtd\"><math><mstyle><mn>1</mn><mo>+</mo><mn>2</mn></mstyle></math>";
		assertEquals(mathMLConverter.toAscii(mathml),"1 + 2");
	}

}
