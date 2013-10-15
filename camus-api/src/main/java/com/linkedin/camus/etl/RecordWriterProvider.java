package com.linkedin.camus.etl;

import com.linkedin.camus.coders.CamusWrapper;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputCommitter;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: tnorden@visiblemeasures.com
 * Date: 10/15/13
 * Time: 1:07 PM
 */
public interface RecordWriterProvider {

  String getFilenameExtension();

  RecordWriter<IEtlKey, CamusWrapper> getDataRecordWriter(
      TaskAttemptContext context, String fileName, CamusWrapper data, FileOutputCommitter committer) throws IOException,
      InterruptedException;
}
