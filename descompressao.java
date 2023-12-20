import java.util.Scanner;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    byte bytes[] = new byte[10];

    var rand = new Random();
    rand.nextBytes(bytes);

    System.out.println("Valores antes da compressão:");
    for (int i = 0; i < bytes.length; i++) {
      System.out.println(bytes[i]);
    }
    
    byte new_bytes[] = compress(bytes);

    System.out.println("Valores após compressão:");
    for (int i = 0; i < new_bytes.length; i++) {
      System.out.println(new_bytes[i]);
    }

    bytes = decompress(new_bytes);

    System.out.println("\nValores após descompressão:");
    for (int i = 0; i < bytes.length; i++) {
      System.out.println(bytes[i]);
    }
  }

  static byte[] compress(byte[] bytes) {
    byte compressed_bytes[] = new byte[bytes.length / 2];
    byte helper_1;
    byte helper_2;

    for (int i = 0; i < compressed_bytes.length; i++) {
      helper_1 = (byte) (bytes[i * 2] >>> 4);
      helper_1 = (byte) (helper_1 << 4);

      helper_2 = (byte) (bytes[i * 2 + 1] >>> 4);

      compressed_bytes[i] = (byte)(helper_1 + helper_2);
    }

    return compressed_bytes;
  }

  static byte[] decompress(byte[] bytes) {
    byte decompressed_bytes[] = new byte[bytes.length*2];
    byte helper_1;
    byte helper_2;

    for (int i = 0; i < bytes.length; i++) {
      helper_1 = (byte)(bytes[i] >>> 4);
      helper_1 = (byte)(helper_1 << 4);
      
      helper_2 = (byte)(bytes[i] << 4);

      decompressed_bytes[i*2] = helper_1;
      decompressed_bytes[i*2+1] = helper_2;
    }

    return decompressed_bytes;
  }
}

// 11010011
// 11001111

// 11011100
// helper_1 = (11011100 >>> 4) = 00001101 << 4 = 11010000
// helper_2 = (11011100 << 4) = 11000000
