package com.aliyun.aksls.chlde.log.producer.errors;

/** The errors below are transient exceptions that if retried may succeed. */
public class RetriableErrors {

  public static final String REQUEST_ERROR = "RequestError";

  public static final String UNAUTHORIZED = "Unauthorized";

  public static final String WRITE_QUOTA_EXCEED = "WriteQuotaExceed";

  public static final String SHARD_WRITE_QUOTA_EXCEED = "ShardWriteQuotaExceed";

  public static final String EXCEED_QUOTA = "ExceedQuota";

  public static final String INTERNAL_SERVER_ERROR = "InternalServerError";

  public static final String SERVER_BUSY = "ServerBusy";

  public static final String BAD_RESPONSE = "BadResponse";
}