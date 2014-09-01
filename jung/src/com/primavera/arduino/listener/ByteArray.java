package com.primavera.arduino.listener;

class ByteArray {

    public byte[] mByteArray = new byte[1];
    private int mUsedLength;// ������ ����
    public boolean mShowInAscii;

    //appending array
    void add(byte[] newArray) {
        
        while (mUsedLength + newArray.length > mByteArray.length) {
            byte[] tmpArray = new byte[mByteArray.length * 2];
            System.arraycopy(mByteArray, 0, tmpArray, 0, mUsedLength);//mByteArray ������ temArray�� ī��
            mByteArray = tmpArray;
        }

       
        System.arraycopy(newArray, 0, mByteArray, mUsedLength, newArray.length);
        mUsedLength += newArray.length;
    }

    
    void toggleCoding() {
        mShowInAscii = !mShowInAscii;
    }

    @Override
    public String toString() {
    	// mByteArray�� ������ StringBuilder�� �̿��Ͽ� return �Ѵ�
        StringBuilder hexStr = new StringBuilder();

        if (mShowInAscii) {
        	//mByteArray�� �� ���Ҹ� �˻��� ���ڳ� ���ڶ�� hexStr�� ��Ʈ������ appending �Ѵ�
        	//���ڳ� ���ڰ� �ƴ϶�� . �� appending �Ѵ�
            for (int i = 0; i < mUsedLength; i++) {
              //  if (Character.isLetterOrDigit(mByteArray[i])) {
                    hexStr.append(new String(new byte[] {mByteArray[i]}));
             //   } else {
              //      hexStr.append('.');
               // }
            }
        } else {
            for (int i = 0; i < mUsedLength; i++) {
                hexStr.append(String.format("%1$02X", mByteArray[i]));
                hexStr.append(" ");
            }
        }

        return hexStr.toString();
    }
}