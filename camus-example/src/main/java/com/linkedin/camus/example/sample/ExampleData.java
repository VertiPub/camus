/**
 * Autogenerated by Avro
 * 
 * DO NOT EDIT DIRECTLY
 */
package com.linkedin.camus.example.sample;  
@SuppressWarnings("all")
/** This is an example logs format */
@org.apache.avro.specific.AvroGenerated
public class ExampleData extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"ExampleData\",\"namespace\":\"com.linkedin.camus.example.sample\",\"doc\":\"This is an example logs format\",\"fields\":[{\"name\":\"logTime\",\"type\":\"long\",\"default\":null},{\"name\":\"logValues\",\"type\":{\"type\":\"map\",\"values\":\"string\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }
  @Deprecated public long logTime;
  @Deprecated public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> logValues;

  /**
   * Default constructor.
   */
  public ExampleData() {}

  /**
   * All-args constructor.
   */
  public ExampleData(java.lang.Long logTime, java.util.Map<java.lang.CharSequence,java.lang.CharSequence> logValues) {
    this.logTime = logTime;
    this.logValues = logValues;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call. 
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return logTime;
    case 1: return logValues;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }
  // Used by DatumReader.  Applications should not call. 
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: logTime = (java.lang.Long)value$; break;
    case 1: logValues = (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'logTime' field.
   */
  public java.lang.Long getLogTime() {
    return logTime;
  }

  /**
   * Sets the value of the 'logTime' field.
   * @param value the value to set.
   */
  public void setLogTime(java.lang.Long value) {
    this.logTime = value;
  }

  /**
   * Gets the value of the 'logValues' field.
   */
  public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getLogValues() {
    return logValues;
  }

  /**
   * Sets the value of the 'logValues' field.
   * @param value the value to set.
   */
  public void setLogValues(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
    this.logValues = value;
  }

  /** Creates a new ExampleData RecordBuilder */
  public static com.linkedin.camus.example.sample.ExampleData.Builder newBuilder() {
    return new com.linkedin.camus.example.sample.ExampleData.Builder();
  }
  
  /** Creates a new ExampleData RecordBuilder by copying an existing Builder */
  public static com.linkedin.camus.example.sample.ExampleData.Builder newBuilder(com.linkedin.camus.example.sample.ExampleData.Builder other) {
    return new com.linkedin.camus.example.sample.ExampleData.Builder(other);
  }
  
  /** Creates a new ExampleData RecordBuilder by copying an existing ExampleData instance */
  public static com.linkedin.camus.example.sample.ExampleData.Builder newBuilder(com.linkedin.camus.example.sample.ExampleData other) {
    return new com.linkedin.camus.example.sample.ExampleData.Builder(other);
  }
  
  /**
   * RecordBuilder for ExampleData instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<ExampleData>
    implements org.apache.avro.data.RecordBuilder<ExampleData> {

    private long logTime;
    private java.util.Map<java.lang.CharSequence,java.lang.CharSequence> logValues;

    /** Creates a new Builder */
    private Builder() {
      super(com.linkedin.camus.example.sample.ExampleData.SCHEMA$);
    }
    
    /** Creates a Builder by copying an existing Builder */
    private Builder(com.linkedin.camus.example.sample.ExampleData.Builder other) {
      super(other);
    }
    
    /** Creates a Builder by copying an existing ExampleData instance */
    private Builder(com.linkedin.camus.example.sample.ExampleData other) {
            super(com.linkedin.camus.example.sample.ExampleData.SCHEMA$);
      if (isValidValue(fields()[0], other.logTime)) {
        this.logTime = data().deepCopy(fields()[0].schema(), other.logTime);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.logValues)) {
        this.logValues = data().deepCopy(fields()[1].schema(), other.logValues);
        fieldSetFlags()[1] = true;
      }
    }

    /** Gets the value of the 'logTime' field */
    public java.lang.Long getLogTime() {
      return logTime;
    }
    
    /** Sets the value of the 'logTime' field */
    public com.linkedin.camus.example.sample.ExampleData.Builder setLogTime(long value) {
      validate(fields()[0], value);
      this.logTime = value;
      fieldSetFlags()[0] = true;
      return this; 
    }
    
    /** Checks whether the 'logTime' field has been set */
    public boolean hasLogTime() {
      return fieldSetFlags()[0];
    }
    
    /** Clears the value of the 'logTime' field */
    public com.linkedin.camus.example.sample.ExampleData.Builder clearLogTime() {
      fieldSetFlags()[0] = false;
      return this;
    }

    /** Gets the value of the 'logValues' field */
    public java.util.Map<java.lang.CharSequence,java.lang.CharSequence> getLogValues() {
      return logValues;
    }
    
    /** Sets the value of the 'logValues' field */
    public com.linkedin.camus.example.sample.ExampleData.Builder setLogValues(java.util.Map<java.lang.CharSequence,java.lang.CharSequence> value) {
      validate(fields()[1], value);
      this.logValues = value;
      fieldSetFlags()[1] = true;
      return this; 
    }
    
    /** Checks whether the 'logValues' field has been set */
    public boolean hasLogValues() {
      return fieldSetFlags()[1];
    }
    
    /** Clears the value of the 'logValues' field */
    public com.linkedin.camus.example.sample.ExampleData.Builder clearLogValues() {
      logValues = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    public ExampleData build() {
      try {
        ExampleData record = new ExampleData();
        record.logTime = fieldSetFlags()[0] ? this.logTime : (java.lang.Long) defaultValue(fields()[0]);
        record.logValues = fieldSetFlags()[1] ? this.logValues : (java.util.Map<java.lang.CharSequence,java.lang.CharSequence>) defaultValue(fields()[1]);
        return record;
      } catch (Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }
}
