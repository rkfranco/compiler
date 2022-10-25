package br.com.furb.compilador.gals;

public interface ScannerConstants
{
    int[] SCANNER_TABLE_INDEXES = 
    {
        0,
        88,
        88,
        89,
        280,
        471,
        471,
        472,
        472,
        472,
        472,
        472,
        472,
        472,
        482,
        482,
        493,
        505,
        505,
        505,
        505,
        506,
        506,
        569,
        570,
        573,
        573,
        574,
        574,
        574,
        574,
        574,
        584,
        595,
        604,
        604,
        667,
        729,
        920,
        920,
        920,
        929,
        939,
        1131,
        1141,
        1141
    };

    int[][] SCANNER_TABLE = 
    {
        {9, 1},
        {10, 1},
        {32, 1},
        {33, 2},
        {34, 3},
        {35, 4},
        {37, 5},
        {38, 6},
        {40, 7},
        {41, 8},
        {42, 9},
        {43, 10},
        {44, 11},
        {45, 12},
        {46, 13},
        {47, 14},
        {48, 15},
        {49, 16},
        {50, 16},
        {51, 16},
        {52, 16},
        {53, 16},
        {54, 16},
        {55, 16},
        {56, 16},
        {57, 16},
        {58, 17},
        {59, 18},
        {60, 19},
        {61, 20},
        {62, 21},
        {65, 22},
        {66, 22},
        {67, 22},
        {68, 22},
        {69, 22},
        {70, 22},
        {71, 22},
        {72, 22},
        {73, 22},
        {74, 22},
        {75, 22},
        {76, 22},
        {77, 22},
        {78, 22},
        {79, 22},
        {80, 22},
        {81, 22},
        {82, 22},
        {83, 22},
        {84, 22},
        {85, 22},
        {86, 22},
        {87, 22},
        {88, 22},
        {89, 22},
        {90, 22},
        {91, 23},
        {92, 24},
        {97, 22},
        {98, 22},
        {99, 22},
        {100, 22},
        {101, 22},
        {102, 22},
        {103, 22},
        {104, 22},
        {105, 22},
        {106, 22},
        {107, 22},
        {108, 22},
        {109, 22},
        {110, 22},
        {111, 22},
        {112, 22},
        {113, 22},
        {114, 22},
        {115, 22},
        {116, 22},
        {117, 22},
        {118, 22},
        {119, 22},
        {120, 22},
        {121, 22},
        {122, 22},
        {123, 25},
        {124, 26},
        {125, 27},
        {61, 28},
        {9, 3},
        {13, 3},
        {32, 3},
        {33, 3},
        {34, 29},
        {35, 3},
        {36, 3},
        {37, 3},
        {38, 3},
        {39, 3},
        {40, 3},
        {41, 3},
        {42, 3},
        {43, 3},
        {44, 3},
        {45, 3},
        {46, 3},
        {47, 3},
        {48, 3},
        {49, 3},
        {50, 3},
        {51, 3},
        {52, 3},
        {53, 3},
        {54, 3},
        {55, 3},
        {56, 3},
        {57, 3},
        {58, 3},
        {59, 3},
        {60, 3},
        {61, 3},
        {62, 3},
        {63, 3},
        {64, 3},
        {65, 3},
        {66, 3},
        {67, 3},
        {68, 3},
        {69, 3},
        {70, 3},
        {71, 3},
        {72, 3},
        {73, 3},
        {74, 3},
        {75, 3},
        {76, 3},
        {77, 3},
        {78, 3},
        {79, 3},
        {80, 3},
        {81, 3},
        {82, 3},
        {83, 3},
        {84, 3},
        {85, 3},
        {86, 3},
        {87, 3},
        {88, 3},
        {89, 3},
        {90, 3},
        {91, 3},
        {93, 3},
        {94, 3},
        {95, 3},
        {96, 3},
        {97, 3},
        {98, 3},
        {99, 3},
        {100, 3},
        {101, 3},
        {102, 3},
        {103, 3},
        {104, 3},
        {105, 3},
        {106, 3},
        {107, 3},
        {108, 3},
        {109, 3},
        {110, 3},
        {111, 3},
        {112, 3},
        {113, 3},
        {114, 3},
        {115, 3},
        {116, 3},
        {117, 3},
        {118, 3},
        {119, 3},
        {120, 3},
        {121, 3},
        {122, 3},
        {123, 3},
        {124, 3},
        {125, 3},
        {126, 3},
        {161, 3},
        {162, 3},
        {163, 3},
        {164, 3},
        {165, 3},
        {166, 3},
        {167, 3},
        {168, 3},
        {169, 3},
        {170, 3},
        {171, 3},
        {172, 3},
        {173, 3},
        {174, 3},
        {175, 3},
        {176, 3},
        {177, 3},
        {178, 3},
        {179, 3},
        {180, 3},
        {181, 3},
        {182, 3},
        {183, 3},
        {184, 3},
        {185, 3},
        {186, 3},
        {187, 3},
        {188, 3},
        {189, 3},
        {190, 3},
        {191, 3},
        {192, 3},
        {193, 3},
        {194, 3},
        {195, 3},
        {196, 3},
        {197, 3},
        {198, 3},
        {199, 3},
        {200, 3},
        {201, 3},
        {202, 3},
        {203, 3},
        {204, 3},
        {205, 3},
        {206, 3},
        {207, 3},
        {208, 3},
        {209, 3},
        {210, 3},
        {211, 3},
        {212, 3},
        {213, 3},
        {214, 3},
        {215, 3},
        {216, 3},
        {217, 3},
        {218, 3},
        {219, 3},
        {220, 3},
        {221, 3},
        {222, 3},
        {223, 3},
        {224, 3},
        {225, 3},
        {226, 3},
        {227, 3},
        {228, 3},
        {229, 3},
        {230, 3},
        {231, 3},
        {232, 3},
        {233, 3},
        {234, 3},
        {235, 3},
        {236, 3},
        {237, 3},
        {238, 3},
        {239, 3},
        {240, 3},
        {241, 3},
        {242, 3},
        {243, 3},
        {244, 3},
        {245, 3},
        {246, 3},
        {247, 3},
        {248, 3},
        {249, 3},
        {250, 3},
        {251, 3},
        {252, 3},
        {253, 3},
        {254, 3},
        {255, 3},
        {9, 4},
        {32, 4},
        {33, 4},
        {34, 4},
        {35, 4},
        {36, 4},
        {37, 4},
        {38, 4},
        {39, 4},
        {40, 4},
        {41, 4},
        {42, 4},
        {43, 4},
        {44, 4},
        {45, 4},
        {46, 4},
        {47, 4},
        {48, 4},
        {49, 4},
        {50, 4},
        {51, 4},
        {52, 4},
        {53, 4},
        {54, 4},
        {55, 4},
        {56, 4},
        {57, 4},
        {58, 4},
        {59, 4},
        {60, 4},
        {61, 4},
        {62, 4},
        {63, 4},
        {64, 4},
        {65, 4},
        {66, 4},
        {67, 4},
        {68, 4},
        {69, 4},
        {70, 4},
        {71, 4},
        {72, 4},
        {73, 4},
        {74, 4},
        {75, 4},
        {76, 4},
        {77, 4},
        {78, 4},
        {79, 4},
        {80, 4},
        {81, 4},
        {82, 4},
        {83, 4},
        {84, 4},
        {85, 4},
        {86, 4},
        {87, 4},
        {88, 4},
        {89, 4},
        {90, 4},
        {91, 4},
        {92, 4},
        {93, 4},
        {94, 4},
        {95, 4},
        {96, 4},
        {97, 4},
        {98, 4},
        {99, 4},
        {100, 4},
        {101, 4},
        {102, 4},
        {103, 4},
        {104, 4},
        {105, 4},
        {106, 4},
        {107, 4},
        {108, 4},
        {109, 4},
        {110, 4},
        {111, 4},
        {112, 4},
        {113, 4},
        {114, 4},
        {115, 4},
        {116, 4},
        {117, 4},
        {118, 4},
        {119, 4},
        {120, 4},
        {121, 4},
        {122, 4},
        {123, 4},
        {124, 4},
        {125, 4},
        {126, 4},
        {161, 4},
        {162, 4},
        {163, 4},
        {164, 4},
        {165, 4},
        {166, 4},
        {167, 4},
        {168, 4},
        {169, 4},
        {170, 4},
        {171, 4},
        {172, 4},
        {173, 4},
        {174, 4},
        {175, 4},
        {176, 4},
        {177, 4},
        {178, 4},
        {179, 4},
        {180, 4},
        {181, 4},
        {182, 4},
        {183, 4},
        {184, 4},
        {185, 4},
        {186, 4},
        {187, 4},
        {188, 4},
        {189, 4},
        {190, 4},
        {191, 4},
        {192, 4},
        {193, 4},
        {194, 4},
        {195, 4},
        {196, 4},
        {197, 4},
        {198, 4},
        {199, 4},
        {200, 4},
        {201, 4},
        {202, 4},
        {203, 4},
        {204, 4},
        {205, 4},
        {206, 4},
        {207, 4},
        {208, 4},
        {209, 4},
        {210, 4},
        {211, 4},
        {212, 4},
        {213, 4},
        {214, 4},
        {215, 4},
        {216, 4},
        {217, 4},
        {218, 4},
        {219, 4},
        {220, 4},
        {221, 4},
        {222, 4},
        {223, 4},
        {224, 4},
        {225, 4},
        {226, 4},
        {227, 4},
        {228, 4},
        {229, 4},
        {230, 4},
        {231, 4},
        {232, 4},
        {233, 4},
        {234, 4},
        {235, 4},
        {236, 4},
        {237, 4},
        {238, 4},
        {239, 4},
        {240, 4},
        {241, 4},
        {242, 4},
        {243, 4},
        {244, 4},
        {245, 4},
        {246, 4},
        {247, 4},
        {248, 4},
        {249, 4},
        {250, 4},
        {251, 4},
        {252, 4},
        {253, 4},
        {254, 4},
        {255, 4},
        {38, 30},
        {48, 31},
        {49, 32},
        {50, 32},
        {51, 32},
        {52, 32},
        {53, 32},
        {54, 32},
        {55, 32},
        {56, 32},
        {57, 32},
        {46, 13},
        {48, 15},
        {49, 16},
        {50, 16},
        {51, 16},
        {52, 16},
        {53, 16},
        {54, 16},
        {55, 16},
        {56, 16},
        {57, 16},
        {46, 13},
        {48, 15},
        {49, 16},
        {50, 16},
        {51, 16},
        {52, 16},
        {53, 16},
        {54, 16},
        {55, 16},
        {56, 16},
        {57, 16},
        {100, 33},
        {61, 34},
        {48, 35},
        {49, 35},
        {50, 35},
        {51, 35},
        {52, 35},
        {53, 35},
        {54, 35},
        {55, 35},
        {56, 35},
        {57, 35},
        {65, 22},
        {66, 22},
        {67, 22},
        {68, 22},
        {69, 22},
        {70, 22},
        {71, 22},
        {72, 22},
        {73, 22},
        {74, 22},
        {75, 22},
        {76, 22},
        {77, 22},
        {78, 22},
        {79, 22},
        {80, 22},
        {81, 22},
        {82, 22},
        {83, 22},
        {84, 22},
        {85, 22},
        {86, 22},
        {87, 22},
        {88, 22},
        {89, 22},
        {90, 22},
        {95, 36},
        {97, 22},
        {98, 22},
        {99, 22},
        {100, 22},
        {101, 22},
        {102, 22},
        {103, 22},
        {104, 22},
        {105, 22},
        {106, 22},
        {107, 22},
        {108, 22},
        {109, 22},
        {110, 22},
        {111, 22},
        {112, 22},
        {113, 22},
        {114, 22},
        {115, 22},
        {116, 22},
        {117, 22},
        {118, 22},
        {119, 22},
        {120, 22},
        {121, 22},
        {122, 22},
        {10, 37},
        {110, 38},
        {115, 38},
        {116, 38},
        {124, 39},
        {48, 31},
        {49, 32},
        {50, 32},
        {51, 32},
        {52, 32},
        {53, 32},
        {54, 32},
        {55, 32},
        {56, 32},
        {57, 32},
        {48, 31},
        {49, 32},
        {50, 32},
        {51, 32},
        {52, 32},
        {53, 32},
        {54, 32},
        {55, 32},
        {56, 32},
        {57, 32},
        {100, 40},
        {49, 41},
        {50, 41},
        {51, 41},
        {52, 41},
        {53, 41},
        {54, 41},
        {55, 41},
        {56, 41},
        {57, 41},
        {48, 35},
        {49, 35},
        {50, 35},
        {51, 35},
        {52, 35},
        {53, 35},
        {54, 35},
        {55, 35},
        {56, 35},
        {57, 35},
        {65, 35},
        {66, 35},
        {67, 35},
        {68, 35},
        {69, 35},
        {70, 35},
        {71, 35},
        {72, 35},
        {73, 35},
        {74, 35},
        {75, 35},
        {76, 35},
        {77, 35},
        {78, 35},
        {79, 35},
        {80, 35},
        {81, 35},
        {82, 35},
        {83, 35},
        {84, 35},
        {85, 35},
        {86, 35},
        {87, 35},
        {88, 35},
        {89, 35},
        {90, 35},
        {95, 36},
        {97, 35},
        {98, 35},
        {99, 35},
        {100, 35},
        {101, 35},
        {102, 35},
        {103, 35},
        {104, 35},
        {105, 35},
        {106, 35},
        {107, 35},
        {108, 35},
        {109, 35},
        {110, 35},
        {111, 35},
        {112, 35},
        {113, 35},
        {114, 35},
        {115, 35},
        {116, 35},
        {117, 35},
        {118, 35},
        {119, 35},
        {120, 35},
        {121, 35},
        {122, 35},
        {48, 35},
        {49, 35},
        {50, 35},
        {51, 35},
        {52, 35},
        {53, 35},
        {54, 35},
        {55, 35},
        {56, 35},
        {57, 35},
        {65, 35},
        {66, 35},
        {67, 35},
        {68, 35},
        {69, 35},
        {70, 35},
        {71, 35},
        {72, 35},
        {73, 35},
        {74, 35},
        {75, 35},
        {76, 35},
        {77, 35},
        {78, 35},
        {79, 35},
        {80, 35},
        {81, 35},
        {82, 35},
        {83, 35},
        {84, 35},
        {85, 35},
        {86, 35},
        {87, 35},
        {88, 35},
        {89, 35},
        {90, 35},
        {97, 35},
        {98, 35},
        {99, 35},
        {100, 35},
        {101, 35},
        {102, 35},
        {103, 35},
        {104, 35},
        {105, 35},
        {106, 35},
        {107, 35},
        {108, 35},
        {109, 35},
        {110, 35},
        {111, 35},
        {112, 35},
        {113, 35},
        {114, 35},
        {115, 35},
        {116, 35},
        {117, 35},
        {118, 35},
        {119, 35},
        {120, 35},
        {121, 35},
        {122, 35},
        {9, 37},
        {10, 42},
        {13, 37},
        {32, 37},
        {33, 37},
        {34, 37},
        {35, 37},
        {36, 37},
        {37, 37},
        {38, 37},
        {39, 37},
        {40, 37},
        {41, 37},
        {42, 37},
        {43, 37},
        {44, 37},
        {45, 37},
        {46, 37},
        {47, 37},
        {48, 37},
        {49, 37},
        {50, 37},
        {51, 37},
        {52, 37},
        {53, 37},
        {54, 37},
        {55, 37},
        {56, 37},
        {57, 37},
        {58, 37},
        {59, 37},
        {60, 37},
        {61, 37},
        {62, 37},
        {63, 37},
        {64, 37},
        {65, 37},
        {66, 37},
        {67, 37},
        {68, 37},
        {69, 37},
        {70, 37},
        {71, 37},
        {72, 37},
        {73, 37},
        {74, 37},
        {75, 37},
        {76, 37},
        {77, 37},
        {78, 37},
        {79, 37},
        {80, 37},
        {81, 37},
        {82, 37},
        {83, 37},
        {84, 37},
        {85, 37},
        {86, 37},
        {87, 37},
        {88, 37},
        {89, 37},
        {90, 37},
        {92, 37},
        {94, 37},
        {95, 37},
        {96, 37},
        {97, 37},
        {98, 37},
        {99, 37},
        {100, 37},
        {101, 37},
        {102, 37},
        {103, 37},
        {104, 37},
        {105, 37},
        {106, 37},
        {107, 37},
        {108, 37},
        {109, 37},
        {110, 37},
        {111, 37},
        {112, 37},
        {113, 37},
        {114, 37},
        {115, 37},
        {116, 37},
        {117, 37},
        {118, 37},
        {119, 37},
        {120, 37},
        {121, 37},
        {122, 37},
        {123, 37},
        {124, 37},
        {125, 37},
        {126, 37},
        {161, 37},
        {162, 37},
        {163, 37},
        {164, 37},
        {165, 37},
        {166, 37},
        {167, 37},
        {168, 37},
        {169, 37},
        {170, 37},
        {171, 37},
        {172, 37},
        {173, 37},
        {174, 37},
        {175, 37},
        {176, 37},
        {177, 37},
        {178, 37},
        {179, 37},
        {180, 37},
        {181, 37},
        {182, 37},
        {183, 37},
        {184, 37},
        {185, 37},
        {186, 37},
        {187, 37},
        {188, 37},
        {189, 37},
        {190, 37},
        {191, 37},
        {192, 37},
        {193, 37},
        {194, 37},
        {195, 37},
        {196, 37},
        {197, 37},
        {198, 37},
        {199, 37},
        {200, 37},
        {201, 37},
        {202, 37},
        {203, 37},
        {204, 37},
        {205, 37},
        {206, 37},
        {207, 37},
        {208, 37},
        {209, 37},
        {210, 37},
        {211, 37},
        {212, 37},
        {213, 37},
        {214, 37},
        {215, 37},
        {216, 37},
        {217, 37},
        {218, 37},
        {219, 37},
        {220, 37},
        {221, 37},
        {222, 37},
        {223, 37},
        {224, 37},
        {225, 37},
        {226, 37},
        {227, 37},
        {228, 37},
        {229, 37},
        {230, 37},
        {231, 37},
        {232, 37},
        {233, 37},
        {234, 37},
        {235, 37},
        {236, 37},
        {237, 37},
        {238, 37},
        {239, 37},
        {240, 37},
        {241, 37},
        {242, 37},
        {243, 37},
        {244, 37},
        {245, 37},
        {246, 37},
        {247, 37},
        {248, 37},
        {249, 37},
        {250, 37},
        {251, 37},
        {252, 37},
        {253, 37},
        {254, 37},
        {255, 37},
        {49, 43},
        {50, 43},
        {51, 43},
        {52, 43},
        {53, 43},
        {54, 43},
        {55, 43},
        {56, 43},
        {57, 43},
        {48, 41},
        {49, 41},
        {50, 41},
        {51, 41},
        {52, 41},
        {53, 41},
        {54, 41},
        {55, 41},
        {56, 41},
        {57, 41},
        {9, 37},
        {10, 42},
        {13, 37},
        {32, 37},
        {33, 37},
        {34, 37},
        {35, 37},
        {36, 37},
        {37, 37},
        {38, 37},
        {39, 37},
        {40, 37},
        {41, 37},
        {42, 37},
        {43, 37},
        {44, 37},
        {45, 37},
        {46, 37},
        {47, 37},
        {48, 37},
        {49, 37},
        {50, 37},
        {51, 37},
        {52, 37},
        {53, 37},
        {54, 37},
        {55, 37},
        {56, 37},
        {57, 37},
        {58, 37},
        {59, 37},
        {60, 37},
        {61, 37},
        {62, 37},
        {63, 37},
        {64, 37},
        {65, 37},
        {66, 37},
        {67, 37},
        {68, 37},
        {69, 37},
        {70, 37},
        {71, 37},
        {72, 37},
        {73, 37},
        {74, 37},
        {75, 37},
        {76, 37},
        {77, 37},
        {78, 37},
        {79, 37},
        {80, 37},
        {81, 37},
        {82, 37},
        {83, 37},
        {84, 37},
        {85, 37},
        {86, 37},
        {87, 37},
        {88, 37},
        {89, 37},
        {90, 37},
        {92, 37},
        {93, 44},
        {94, 37},
        {95, 37},
        {96, 37},
        {97, 37},
        {98, 37},
        {99, 37},
        {100, 37},
        {101, 37},
        {102, 37},
        {103, 37},
        {104, 37},
        {105, 37},
        {106, 37},
        {107, 37},
        {108, 37},
        {109, 37},
        {110, 37},
        {111, 37},
        {112, 37},
        {113, 37},
        {114, 37},
        {115, 37},
        {116, 37},
        {117, 37},
        {118, 37},
        {119, 37},
        {120, 37},
        {121, 37},
        {122, 37},
        {123, 37},
        {124, 37},
        {125, 37},
        {126, 37},
        {161, 37},
        {162, 37},
        {163, 37},
        {164, 37},
        {165, 37},
        {166, 37},
        {167, 37},
        {168, 37},
        {169, 37},
        {170, 37},
        {171, 37},
        {172, 37},
        {173, 37},
        {174, 37},
        {175, 37},
        {176, 37},
        {177, 37},
        {178, 37},
        {179, 37},
        {180, 37},
        {181, 37},
        {182, 37},
        {183, 37},
        {184, 37},
        {185, 37},
        {186, 37},
        {187, 37},
        {188, 37},
        {189, 37},
        {190, 37},
        {191, 37},
        {192, 37},
        {193, 37},
        {194, 37},
        {195, 37},
        {196, 37},
        {197, 37},
        {198, 37},
        {199, 37},
        {200, 37},
        {201, 37},
        {202, 37},
        {203, 37},
        {204, 37},
        {205, 37},
        {206, 37},
        {207, 37},
        {208, 37},
        {209, 37},
        {210, 37},
        {211, 37},
        {212, 37},
        {213, 37},
        {214, 37},
        {215, 37},
        {216, 37},
        {217, 37},
        {218, 37},
        {219, 37},
        {220, 37},
        {221, 37},
        {222, 37},
        {223, 37},
        {224, 37},
        {225, 37},
        {226, 37},
        {227, 37},
        {228, 37},
        {229, 37},
        {230, 37},
        {231, 37},
        {232, 37},
        {233, 37},
        {234, 37},
        {235, 37},
        {236, 37},
        {237, 37},
        {238, 37},
        {239, 37},
        {240, 37},
        {241, 37},
        {242, 37},
        {243, 37},
        {244, 37},
        {245, 37},
        {246, 37},
        {247, 37},
        {248, 37},
        {249, 37},
        {250, 37},
        {251, 37},
        {252, 37},
        {253, 37},
        {254, 37},
        {255, 37},
        {48, 43},
        {49, 43},
        {50, 43},
        {51, 43},
        {52, 43},
        {53, 43},
        {54, 43},
        {55, 43},
        {56, 43},
        {57, 43}
    };

    int[] TOKEN_STATE = {-2,  0, 46, -1,  0, 42, -1, 32, 31, 40, 38, 28, 39, -1, 41,  3,  3, 27, 29, 36, 30, 37,  2, -2, -1, 33, -1, 34, 43,  6, 44,  4,  4, -1, 35,  2, -1, -2,  5, 45, -1,  3, -2,  4,  0 };

    int[] SPECIAL_CASES_INDEXES =
        { 0, 0, 0, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20 };

    String[] SPECIAL_CASES_KEYS =
        {  "boolean", "break", "char", "do", "else", "end", "false", "float", "fun", "if", "int", "main", "print", "println", "readln", "string", "true", "val", "var", "while" };

    int[] SPECIAL_CASES_VALUES =
        {  7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26 };

    String[] SCANNER_ERROR =
    {
        "Caractere não esperado",
        "",
        "",
        "Erro identificando cstring",
        "",
        "",
        "Erro identificando \"&&\"",
        "",
        "",
        "",
        "",
        "",
        "",
        "Erro identificando cfloat",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "Erro identificando <ignorar>",
        "Erro identificando cchar",
        "",
        "Erro identificando \"||\"",
        "",
        "",
        "",
        "",
        "",
        "",
        "Erro identificando cint",
        "",
        "",
        "Erro identificando identificador",
        "Erro identificando <ignorar>",
        "",
        "",
        "Erro identificando cfloat",
        "",
        "Erro identificando <ignorar>",
        "",
        ""
    };

}
