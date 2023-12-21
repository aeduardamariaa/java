/*
* COMPRESSOR DE 2 BITS
*/

// import java.util.Random;

// class Main {
//   public static void main(String[] args) {
//     byte bytes[] = new byte[10];

//     var rand = new Random();
//     rand.nextBytes(bytes);

//     System.out.println("Valores antes da compressão:");
//     for (int i = 0; i < bytes.length; i++) {
//       System.out.println(bytes[i]);
//     }

//     byte new_bytes[] = compress(bytes);

//     System.out.println("Valores após compressão:");
//     for (int i = 0; i < new_bytes.length; i++) {
//       System.out.println(new_bytes[i]);
//     }

//     bytes = decompress(new_bytes);

//     System.out.println("\nValores após descompressão:");
//     for (int i = 0; i < bytes.length; i++) {
//       System.out.println(bytes[i]);
//     }
//   }

//   static byte[] compress(byte[] bytes) {
//     byte compressed_bytes[] = new byte[bytes.length / 2];
//     byte helper_1;
//     byte helper_2;

//     for (int i = 0; i < compressed_bytes.length; i++) {
//       helper_1 = (byte) (bytes[i * 2] >>> 4);
//       helper_1 = (byte) (helper_1 << 4);

//       helper_2 = (byte) (bytes[i * 2 + 1] >>> 4);

//       compressed_bytes[i] = (byte) (helper_1 + helper_2);
//     }

//     return compressed_bytes;
//   }

//   static byte[] decompress(byte[] bytes) {
//     byte decompressed_bytes[] = new byte[bytes.length * 2];
//     byte helper_1;
//     byte helper_2;

//     for (int i = 0; i < bytes.length; i++) {
//       helper_1 = (byte) (bytes[i] >>> 4);
//       helper_1 = (byte) (helper_1 << 4);

//       helper_2 = (byte) (bytes[i] << 4);

//       decompressed_bytes[i * 2] = (byte) (helper_1 + getRandomInRange(0, 15));
//       decompressed_bytes[i * 2 + 1] = (byte) (helper_2 + getRandomInRange(0, 15));
//     }

//     return decompressed_bytes;
//   }

//   static int getRandomInRange(int min, int max) {
//     return (int) ((Math.random() * (max - min)) + min);
//   }
// }

/*
* COMPRESSOR DE 4 BITS
*/

// import java.util.Random;

// class Main {
//   public static void main(String[] args) {
//     byte bytes[] = new byte[12];

//     var rand = new Random();
//     rand.nextBytes(bytes);

//     System.out.println("Valores antes da compressão:");
//     for (int i = 0; i < bytes.length; i++) {
//       System.out.println(bytes[i]);
//     }

//     byte new_bytes[] = compress(bytes);

//     System.out.println("Valores após compressão:");
//     for (int i = 0; i < new_bytes.length; i++) {
//       System.out.println(new_bytes[i]);
//     }

//     bytes = decompress(new_bytes);

//     System.out.println("\nValores após descompressão:");
//     for (int i = 0; i < bytes.length; i++) {
//       System.out.println(bytes[i]);
//     }
//   }

//   static byte[] compress(byte[] bytes) {
//     byte compressed_bytes[] = new byte[bytes.length / 4];
//     byte helpers[] = new byte[4];

//     for (int i = 0; i < compressed_bytes.length; i++) {
//       compressed_bytes[i] = 0;

//       for (int j = 0; j < 4; j++) {
//         helpers[j] = (byte) (bytes[i * 4 + j] >>> 6);
//         helpers[j] = (byte) (helpers[j] << (6 - j * 2));
//         compressed_bytes[i] += (byte) (helpers[j]);
//       }
//     }

//     return compressed_bytes;
//   }

//   static byte[] decompress(byte[] bytes) {
//     byte decompressed_bytes[] = new byte[bytes.length * 4];
//     byte helpers[] = new byte[4];

//     for (int i = 0; i < bytes.length; i++) {
//       for (int j = 0; j < 4; j++) {
//         helpers[j] = (byte) (bytes[i] >>> (6 - j * 2));
//         helpers[j] = (byte) (helpers[j] << 6);
//         decompressed_bytes[i * 4 + j] = (byte) (helpers[j] + getRandomInRange(0, 63));
//       }
//     }

//     return decompressed_bytes;
//   }

//   static int getRandomInRange(int min, int max) {
//     return (int) ((Math.random() * (max - min)) + min);
//   }
// }

/*
* COMPRESSOR DE 3 BITS
*/

import java.util.Random;

class Main {
  public static void main(String[] args) {
    byte bytes[] = new byte[12];

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
    byte helpers[] = new byte[2];

    for (int i = 0; i < compressed_bytes.length; i++) {
      compressed_bytes[i] = 0;

      for (int j = 0; j < 2; j++) {
        helpers[j] = (byte) (bytes[i * 2 + j] >>> 5);
        helpers[j] = (byte) (helpers[j] << (5 - j * 3));
        compressed_bytes[i] += (byte) (helpers[j]);
      }
    }

    return compressed_bytes;
  }

  static byte[] decompress(byte[] bytes) {
    byte decompressed_bytes[] = new byte[bytes.length * 2];
    byte helpers[] = new byte[2];

    for (int i = 0; i < bytes.length; i++) {
      for (int j = 0; j < 2; j++) {
        helpers[j] = (byte) (bytes[i] >>> (5 - j * 3));
        helpers[j] = (byte) (helpers[j] << 5);
        decompressed_bytes[i * 2 + j] = (byte) (helpers[j] + getRandomInRange(0, 31));
      }
    }

    return decompressed_bytes;
  }

  static int getRandomInRange(int min, int max) {
    return (int) ((Math.random() * (max - min)) + min);
  }
}
