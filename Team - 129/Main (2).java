import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ledger = new String[250];
        int index = 0;
        boolean identityVerified = false;
        String userIdStored = "";
        int choice;
        do {
            System.out.println("\n=== CYBER SECURITY SIMULATION ===");
            System.out.println("TEAM ID: T129 - Student Innovation");
            System.out.println("Choose an option:");
            System.out.println("1. Identity Check");
            System.out.println("2. Access Logs");
            System.out.println("3. Certificate Check");
            System.out.println("4. Voting Access");
            System.out.println("5. Threat Monitor");
            System.out.println("6. Data Integrity");
            System.out.println("7. Smart Contract Action");
            System.out.println("8. IoT Device Authentication");
            System.out.println("9. Blockchain Certificate Verification");
            System.out.println("10. View Blockchain Ledger");
            System.out.println("0. Exit");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter your ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String pass = scanner.nextLine();
                    System.out.print("Confirm password: ");
                    String confirm = scanner.nextLine();

                    if (pass.equals(confirm) && pass.length() >= 6) {
                        identityVerified = true;
                        userIdStored = userId;
                        System.out.println("✅ Identity Verified.");
                        ledger[index++] = "Identity verified for user: " + userId;
                    } else {
                        identityVerified = false;
                        System.out.println("❌ Identity Failed.");
                        ledger[index++] = "Identity check failed for user: " + userId;
                    }
                    break;

                case 2:
                    if (identityVerified) {
                        System.out.println("Access Log Started...");
                        for (int i = 0; i < 5; i++) {
                            String log = "Access event " + (i + 1) + ": Module " + (char) (65 + i);
                            ledger[index++] = log;
                            System.out.println("✅ " + log);
                        }
                    } else {
                        System.out.println("❌ Identity check needed before accessing logs.");
                    }
                    break;

                case 3:
                    if (identityVerified) {
                        System.out.print("Enter certificate ID: ");
                        String certId = scanner.nextLine();
                        if (certId.length() == 10) {
                            System.out.println("✅ Certificate Valid.");
                            ledger[index++] = "Certificate " + certId + " validated.";
                        } else {
                            System.out.println("❌ Invalid Certificate.");
                            ledger[index++] = "Certificate validation failed for ID: " + certId;
                        }
                    } else {
                        System.out.println("❌ Identity check required first.");
                    }
                    break;

                case 4:
                    if (identityVerified) {
                        System.out.print("Enter voter ID: ");
                        String voterId = scanner.nextLine();
                        if (voterId.length() == 6) {
                            System.out.println("✅ Vote Encrypted.");
                            ledger[index++] = "Vote cast by ID: " + voterId;
                        } else {
                            System.out.println("❌ Invalid Voter ID.");
                        }
                    } else {
                        System.out.println("❌ Complete identity check to access voting.");
                    }
                    break;

                case 5:
                    if (identityVerified) {
                        System.out.println("Threat Monitoring...");
                        for (int i = 1; i <= 3; i++) {
                            String log = "✔ Scan #" + i + ": No threats.";
                            System.out.println(log);
                            ledger[index++] = log;
                        }
                    } else {
                        System.out.println("❌ Identity must be verified for threat check.");
                    }
                    break;

                case 6:
                    if (identityVerified) {
                        System.out.print("Enter data hash: ");
                        String hash1 = scanner.nextLine();
                        System.out.print("Re-enter hash: ");
                        String hash2 = scanner.nextLine();

                        if (hash1.equals(hash2)) {
                            System.out.println("✅ Data Integrity Confirmed.");
                            ledger[index++] = "Hash match: " + hash1;
                        } else {
                            System.out.println("❌ Data mismatch.");
                            ledger[index++] = "Hash mismatch error.";
                        }
                    } else {
                        System.out.println("❌ Access Denied: Identity Required.");
                    }
                    break;

                case 7:
                    if (identityVerified) {
                        System.out.println("Smart Contract Execution...");
                        String[] actions = {
                                "✔ Verified sender.",
                                "✔ Checked balance.",
                                "✔ Transfer executed.",
                                "✔ Transaction logged."
                        };
                        for (String action : actions) {
                            System.out.println(action);
                            ledger[index++] = action;
                        }
                    } else {
                        System.out.println("❌ Cannot execute: Identity Check needed.");
                    }
                    break;

                case 8:
                    if (identityVerified) {
                        System.out.print("Enter MAC address: ");
                        String mac = scanner.nextLine();
                        if (mac.matches("([0-9A-Fa-f]{2}[:-]){5}[0-9A-Fa-f]{2}")) {
                            System.out.println("✅ IoT Device Authenticated.");
                            ledger[index++] = "IoT Auth: " + mac;
                        } else {
                            System.out.println("❌ Invalid MAC.");
                            ledger[index++] = "IoT auth failed for: " + mac;
                        }
                    } else {
                        System.out.println("❌ Identity required before IoT auth.");
                    }
                    break;

                case 9:
                    if (identityVerified) {
                        System.out.print("Enter blockchain cert ID: ");
                        String blockCert = scanner.nextLine();
                        if (blockCert.startsWith("BC") && blockCert.length() == 8) {
                            System.out.println("✅ Blockchain Certificate Verified.");
                            ledger[index++] = "Blockchain cert verified: " + blockCert;
                        } else {
                            System.out.println("❌ Blockchain verification failed.");
                            ledger[index++] = "Blockchain verification failed for: " + blockCert;
                        }
                    } else {
                        System.out.println("❌ Blockchain access requires identity verification.");
                    }
                    break;

                case 10:
                    if (identityVerified) {
                        System.out.println("=== Blockchain Ledger Preview ===");
                        for (int i = 0; i < index; i++) {
                            System.out.println("Block " + (i + 1) + ": " + ledger[i]);
                        }
                    } else {
                        System.out.println("❌ Access Denied: Verify identity first.");
                    }
                    break;

                case 0:
                    System.out.println("🔒 Exiting Simulation. Goodbye.");
                    break;

                default:
                    System.out.println("❌ Invalid choice.");
            }

        } while (choice != 0);

        while (index < 200) {
            ledger[index] = "Block filler " + (index + 1);
            index++;
        }

        scanner.close();
    }
}