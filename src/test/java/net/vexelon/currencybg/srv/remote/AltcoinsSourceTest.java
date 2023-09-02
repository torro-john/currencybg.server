package net.vexelon.currencybg.srv.remote;

import net.vexelon.currencybg.srv.reports.ConsoleReporter;
import net.vexelon.currencybg.srv.tests.TestUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class AltcoinsSourceTest {

	@Test
	public void test_AltcoinsSource01() {

		try {
			var rates = new AltcoinsSource(new ConsoleReporter()).getAltcoinsRates(
					TestUtils.getTestResource("/altcoins.json"));

			// XXX buy/sell rates - size of column is 10!
			// This is not good, because it strips rate infos
			// and the tests should be modified once the db and backend are updated!

			assertEquals("BTC", rates.get(0).getCode());
			assertEquals(1, rates.get(0).getRatio());
			assertEquals("47868.08480999999", rates.get(0).getBuy());
			assertEquals("45984.868176", rates.get(0).getSell());

			assertEquals("ETH", rates.get(1).getCode());
			assertEquals(1, rates.get(1).getRatio());
			assertEquals("3028.2716772", rates.get(1).getBuy());
			assertEquals("2908.809696", rates.get(1).getSell());

			assertEquals("XRP", rates.get(2).getCode());
			assertEquals(1, rates.get(2).getRatio());
			assertEquals("0.92463", rates.get(2).getBuy()); // 0.516897472
			assertEquals("0.8836463999999999", rates.get(2).getSell());

			assertEquals("DASH", rates.get(9).getCode());
			assertEquals(1, rates.get(9).getRatio());
			assertEquals("47.098604", rates.get(9).getBuy()); // 238.8401904
			assertEquals("44.083299", rates.get(9).getSell());

			assertEquals("XLM", rates.get(5).getCode());
			assertEquals(1, rates.get(5).getRatio());
			assertEquals("0.21177211999999998", rates.get(5).getBuy()); // 0.1328160288
			assertEquals("0.19804004999999997", rates.get(5).getSell()); // 0.121593888

			assertEquals("Expected vs. Parsed", AltcoinsSource.CURRENCIES.size(), rates.size());

		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

}
