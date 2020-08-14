package com.londonappbrewery.quizzler;

public class TrueFalse {
      int mQestionId;
      boolean mAns;

      public TrueFalse(int qestionId, boolean ans) {
            mQestionId = qestionId;
            mAns = ans;
      }

      public int getQestionId() {
            return mQestionId;
      }

      public void setQestionId(int qestionId) {
            mQestionId = qestionId;
      }

      public boolean isAns() {
            return mAns;
      }

      public void setAns(boolean ans) {
            mAns = ans;
      }
}
