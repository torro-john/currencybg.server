package net.vexelon.currencybg.srv.reports;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.vexelon.currencybg.srv.GlobalConfig;
import net.vexelon.currencybg.srv.db.DataSource;
import net.vexelon.currencybg.srv.db.DataSourceException;
import net.vexelon.currencybg.srv.db.mysql.MySQLDataSource;
import net.vexelon.currencybg.srv.db.models.ReportData;

public class ReporterHeartbeat implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(ReporterHeartbeat.class);

	@Override
	public void run() {

		try (final DataSource dataSource = new MySQLDataSource()) {

			dataSource.connect();
			List<ReportData> reports = dataSource.getReports();
			StringBuilder errorMessages = new StringBuilder();

			for (ReportData reportData : reports) {
				errorMessages.append(reportData.getMessage());
			}

			if (!StringUtils.isEmpty(errorMessages)) {
				Reporters reporterType = Reporters.getByName(GlobalConfig.INSTANCE.getReportType());

				if (reporterType != null) {
					Reporter reporter = reporterType.newInstance();

					reporter.write(ReporterHeartbeat.class.getSimpleName(), errorMessages.toString());
					reporter.send();

					// Delete send errors
					dataSource.deleteReports(reports);
				}

			}

		} catch (IOException | DataSourceException e) {
			log.error("Could not connect to database!", e);
		}
	}

}
